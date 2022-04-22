import UwULangParser.FunContext
import UwULangParser.StructContext
import UwUMem.nil
import UwUPrimitive.UwUDouble.double
import UwUPrimitive.UwUDouble.long
import org.antlr.v4.runtime.CodePointBuffer
import org.antlr.v4.runtime.CodePointCharStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.RuleContext
import stdlib.UwUString
import java.nio.CharBuffer

class AntlerUwUParser {

    class UwULangStructFinder : UwULangBaseVisitor<Unit>() {
        val imports = mutableListOf<UwUImport>()
        val foundStructs = mutableListOf<StructContext>()
        val foundMethods = mutableListOf<FunContext>()

        override fun visitImpt(ctx: UwULangParser.ImptContext) {  // TODO: function name imports
            val qualifiedName = UwUName(*ctx.IDENTIFIER().map { it.text }.toTypedArray())
            imports.add(UwUImport(qualifiedName))
        }

        override fun visitStruct(ctx: StructContext) {
            foundStructs.add(ctx)
            super.visitStruct(ctx)
        }

        override fun visitFun(ctx: FunContext) {
            foundMethods.add(ctx)
        }
    }

    data class UwUFile(val imports: List<UwUImport>, val structs: List<UwUStruct>)

    fun parseFile(inp: String): UwUFile {
        // Parsing is done in a multistep process to avoid issues when types reference each other.
        // First, an initial sweep for structs is done.  It finds all of the imports, structs, struct fields, and
        // methods in the file.  The imports are parsed first, within the struct finder object.  Then, the structs
        // are instantiated with no fields, methods, or constructors.  The fields from the initial parsing are iterated
        // over, the types resolved, and then they are added to the struct instances.  The same is then done for the
        // methods.  Due to the way that the method implementation works, it is not necessary to load these first by
        // name and then by content.
        val structFinder = UwULangStructFinder()

        val lexed = UwULangLexer(CodePointCharStream.fromBuffer(
            CodePointBuffer.withChars(CharBuffer.wrap(inp.toCharArray()))
        ))

        val parsed = UwULangParser(CommonTokenStream(lexed))

        parsed.file().accept(structFinder)

        val structsWithInstances = structFinder.foundStructs.map { struct ->
            val name = UwUName(struct.IDENTIFIER().text)  // TODO: namespaces

            struct to UwUStruct(name, mutableListOf(), mutableListOf(), UwUConstructor.NullConstructor(UwUPrimitive.UwuVoid))
        }

        for ((struct, instance) in structsWithInstances) {
            val fieldsString = struct.nameTypePair().map { Pair(it.name.text, it.type.text) }
            val fields = fieldsString.mapIndexed { i, it ->
                val type = structFinder.imports.find { im -> im.name.simpleName == it.second }?.run { UwUType.registry[this.name] } ?: structsWithInstances.find { s -> s.second.name.simpleName == it.second }?.second
                UwuField(it.first, type!!, i * 8)
            }
            instance.fields.addAll(fields)

            val methods = struct.`fun`()
            for (method in methods) {
                val name = method.name.text
                val args = method.nameTypePair().map {
                    val type = structFinder.imports.find { im -> im.name.simpleName == it.type.text }?.run { UwUType.registry[this.name] } ?: structsWithInstances.find { s -> s.second.name.simpleName == it.type.text }?.second
                    it.name.text to type!!
                }

                val returnType = method.returnType?.run { structFinder.imports.find { im -> im.name.simpleName == this.text }?.run { UwUType.registry[this.name] } ?: structsWithInstances.find { s -> s.second.name.simpleName == this.text }?.second }
                    ?: UwUPrimitive.UwuVoid

                instance.methods.add(UwULangMethod(name, false, args, returnType, method, structFinder.imports + structsWithInstances.map { UwUImport(it.second.name) }))
            }
        }

        return UwUFile(structFinder.imports, structsWithInstances.map { it.second })
    }

    data class UwULangMethod(override val name: String, override val static: Boolean,
                        override val arguments: List<Pair<String, UwUType>>,
                        override val returnType: UwUType, private val node: RuleContext,
                        private val imports: List<UwUImport>) : UwUMethod {

        override fun invoke(obj: UwUObject, args: List<UwUObject>): UwUObject {
            val scope = UwUInterpreter.ExecutionScope(null, mutableListOf(), mutableSetOf())

            val executor = StatementEvaluator(imports, scope)

            val res = executor.exec(node)

            scope.freeVars()

            return res
        }
    }

    class StatementEvaluator(val imports: List<UwUImport>, var scope: UwUInterpreter.ExecutionScope) : UwULangBaseVisitor<Unit>() {
        private class ReturnException(val obj: UwUObject) : Exception()

        fun exec(node: RuleContext): UwUObject {
            try {
                node.accept(this)
            } catch (e: ReturnException) {
                return e.obj
            }
            return nil
        }

        override fun visitIfStatement(ctx: UwULangParser.IfStatementContext) {
            val condition = ExpressionVisitor(imports, scope).visitExpression(ctx.expression())!!
            if ((condition as UwUObject.UwUStatic).value != 0L) {
                val oldScope = scope
                scope = UwUInterpreter.ExecutionScope(scope, scope.variables.toMutableList(), mutableSetOf())
                try {
                    for (statement in ctx.statement()) {
                        visitStatement(statement)
                    }
                } finally {
                    scope.freeVars()
                    scope = oldScope
                }
            }
        }

        override fun visitWhileLoop(ctx: UwULangParser.WhileLoopContext) {
            val visitor = ExpressionVisitor(imports, scope)
            while ((visitor.visitExpression(ctx.expression())!! as UwUObject.UwUStatic).value != 0L) {
                val oldScope = scope
                scope = UwUInterpreter.ExecutionScope(scope, scope.variables.toMutableList(), mutableSetOf())
                try {
                    for (statement in ctx.statement()) {
                        visitStatement(statement)
                    }
                } finally {
                    scope.freeVars()
                    scope = oldScope
                }
            }
        }

        override fun visitVariableAssign(ctx: UwULangParser.VariableAssignContext) {
            val expr = ExpressionVisitor(imports, scope).visitExpression(ctx.expression())!!
            scope.addedRoots.add(expr)
            val found = scope.variables.find { it.name == ctx.IDENTIFIER().text } ?: UwUInterpreter.UwUVar(ctx.IDENTIFIER().text, nil).also { scope.variables.add(it) }
            found.value = expr
        }

        override fun visitStatement(ctx: UwULangParser.StatementContext) {
            val asIf = ctx.ifStatement()
            val asWhile = ctx.whileLoop()
            val asVar = ctx.variableAssign()
            val asExpr = ctx.expression()
            val asReturn = ctx.RETURN()

            when {
                asIf != null -> visitIfStatement(asIf)
                asWhile != null -> visitWhileLoop(asWhile)
                asVar != null -> visitVariableAssign(asVar)
                asExpr != null -> ExpressionVisitor(imports, scope).visitExpression(asExpr)
                asReturn != null -> {
                    val res = ExpressionVisitor(imports, scope).visitExpression(ctx.expression())
                    throw ReturnException(res!!)
                }
            }
        }
    }

    // TODO: keepalive somehow, maybe make subscopes for each expression evaluation?
    class ExpressionVisitor(val imports: List<UwUImport>, val eScope: UwUInterpreter.ExecutionScope) : UwULangBaseVisitor<UwUObject?>() {
        override fun defaultResult(): UwUObject? {
            return null
        }

        override fun visitFunctionInvocation(ctx: UwULangParser.FunctionInvocationContext): UwUObject {
            val funName = ctx.IDENTIFIER().symbol.text
            val args = ctx.expression().map { visitExpression(it)!! }
            val cls = imports.find { it.funName == funName }!!.name
            val instance = UwUType.registry[cls]!!

            return instance.methods.find { it.name == funName }!!.invoke(nil, args)
        }

        override fun visitExpression(ctx: UwULangParser.ExpressionContext): UwUObject? {
            val asAddition = ctx.addOp()
            val asMultiplication = ctx.mulOp()
            val asVariable = ctx.IDENTIFIER()
            val asFieldAccess = ctx.fieldAccess()
            val asMethodInv = ctx.methodInvocation()
            val asFunctionInv = ctx.functionInvocation()
            val asParenthesis = ctx.OPEN_PAREN()
            val asInteger = ctx.INTEGER()
            val asFloat = ctx.FLOAT()
            val asString = ctx.STRING_LITERAL()
            val asNew = ctx.new_()

            return when {
                asAddition != null -> {
                    val a = visitExpression(ctx.expression(0)) as UwUObject.UwUStatic
                    val b = visitExpression(ctx.expression(1)) as UwUObject.UwUStatic

                    if (a.type == UwUPrimitive.UwULong)
                        if (asAddition.PLUS() != null) UwUObject.UwUStatic(a.value + b.value, UwUPrimitive.UwULong) else UwUObject.UwUStatic(a.value - b.value, UwUPrimitive.UwULong)
                    else
                        if (asAddition.PLUS() != null) UwUObject.UwUStatic((a.value.double() + b.value.double()).long(), UwUPrimitive.UwUDouble) else UwUObject.UwUStatic((a.value.double() - b.value.double()).long(), UwUPrimitive.UwUDouble)
                }
                asMultiplication != null -> {
                    val a = visitExpression(ctx.expression(0)) as UwUObject.UwUStatic
                    val b = visitExpression(ctx.expression(1)) as UwUObject.UwUStatic

                    if (a.type == UwUPrimitive.UwULong)
                        if (asMultiplication.TIMES() != null) UwUObject.UwUStatic(a.value * b.value, UwUPrimitive.UwULong) else UwUObject.UwUStatic(a.value * b.value, UwUPrimitive.UwULong)
                    else
                        if (asMultiplication.TIMES() != null) UwUObject.UwUStatic((a.value.double() / b.value.double()).long(), UwUPrimitive.UwUDouble) else UwUObject.UwUStatic((a.value.double() / b.value.double()).long(), UwUPrimitive.UwUDouble)
                }
                asVariable != null -> {
                    eScope.variables.find { it.name == ctx.IDENTIFIER().text }?.value ?: imports.find { it.name.simpleName == ctx.IDENTIFIER().text }!!.run { UwUConstructor.NullConstructor(UwUType.registry[this.name]!!).invoke(emptyList()) }
                }
                asFieldAccess != null -> {
                    visitExpression(ctx.expression(0)!!)!!
                        .run { (type as UwUStruct).field(this as UwUObject.UwURef, (type as UwUStruct).fields.find { it.name == asFieldAccess.text }!!) }
                }
                asMethodInv != null -> {
                    val obj = visitExpression(ctx.expression(0))!!
                    val args = asMethodInv.functionInvocation().expression().map { visitExpression(it)!! }
                    obj.type.methods.find { it.name == asMethodInv.functionInvocation().IDENTIFIER().text }!!.invoke(obj, args)
                }
                asFunctionInv != null -> visitFunctionInvocation(asFunctionInv)
                asParenthesis != null -> visitExpression(ctx.expression(0))
                asInteger != null -> UwUObject.UwUStatic(asInteger.text.toLong(), UwUPrimitive.UwULong)
                asFloat != null -> UwUObject.UwUStatic(asFloat.text.toDouble().long(), UwUPrimitive.UwUDouble)
                asString != null -> {
                    val str = asString.text.removeSurrounding("\"", "\"")
                    val size = UwUPrimitive.UwULong.constructor.invoke(emptyList())
                        .apply { (this as UwUObject.UwUStatic).value = str.length.toLong() }
                    val obj = UwUString.constructor.invoke(listOf(size)) as UwUObject.UwURef
                    eScope.addRoot(obj)

                    val chars = str.toCharArray().map { UwUObject.UwUStatic(it.code.toLong(), UwUPrimitive.UwUChar) }

                    val array = UwUString.field(obj, UwUString.fields.find { it.name == "chars" }!!) as UwUObject.UwURef
                    UwUArray[UwUPrimitive.UwUChar].setItems(array, chars)

                    obj
                }
                asNew != null -> {
//                    val type = UwUType.registry[asNew.IDENTIFIER().text]
                    TODO()
                }
                else -> nil
            }
        }
    }

    class UwUImport(val name: UwUName, val funName: String? = null) {
        override fun toString(): String {
            return name.names.joinToString(".")
        }
    }

    class CompilerError(cause: String) : Throwable(cause)
}

fun main() {
    // need to instantiate the structs so that they can be used
    UwUPrimitive.UwULong
    UwUPrimitive.UwUDouble
    stdlib.System

    val inp = """
        impowt uwu.System;
        impowt uwu.Wong;
        impowt uwu.Doubwe;
        
        stwuct Foo {
            asiofew: Wong,
            jwoiiof: Doubwe;
            
            static fuwn baw() {
                System.pwintwn("aaaaaaa");
            }
        
            static fuwn bwah() {
                mewt nuwm = 0;
                whiwe (nuwm.wessthan(10)) {
                    System.pwintwn("Hewwo, wowwd!");
                    Foo.baw();
                    nuwm = nuwm + 1;
                }
            }
        }
    """.trimIndent()

    AntlerUwUParser().parseFile(inp)

    val method = (UwUType.registry[UwUName("Foo")] as UwUStruct).methods.find { it.name == "bwah" }!!
    method.invoke(nil, emptyList())
}
