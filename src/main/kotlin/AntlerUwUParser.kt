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
import java.io.File
import java.nio.CharBuffer

class AntlerUwUParser {

    private class UwULangStructFinder : UwULangBaseVisitor<Unit>() {
        val imports = mutableListOf<UwUImport>()
        val foundStructs = mutableListOf<StructContext>()
        val foundMethods = mutableListOf<FunContext>()
        lateinit var pkg: Array<String>

        override fun visitPackageStatement(ctx: UwULangParser.PackageStatementContext) {
            pkg = ctx.qualifiedName().IDENTIFIER().map { it.text }.toTypedArray()
        }

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

    data class UwUFile(val pkg: UwUName, val imports: List<UwUImport>, val structs: List<UwUStruct>)

    fun parseFiles(vararg inp: String): List<UwUFile> {
        // Parsing is done in a multistep process to avoid issues when types reference each other.
        // First, an initial sweep for structs is done.  It finds all of the imports, structs, struct fields, and
        // methods in the file.  The imports are parsed first, within the struct finder object.  Then, the structs
        // are instantiated with no fields, methods, or constructors.  The fields from the initial parsing are iterated
        // over, the types resolved, and then they are added to the struct instances.  The same is then done for the
        // methods.  Due to the way that the method implementation works, it is not necessary to load these first by
        // name and then by content.
//        if (inp.contains('R') || inp.contains('r') || inp.contains('L') || inp.contains('l')) {
//            throw CompilerError("Pwogwam must not contain the wettew between k and n oww q and s!")
//        }

        val finders = inp.map { UwULangStructFinder() to it }
        val parsedFiles = finders.map { UwULangParser(CommonTokenStream(UwULangLexer(CodePointCharStream.fromBuffer(CodePointBuffer.withChars(CharBuffer.wrap(it.second.toCharArray())))))).file() to it.first }
        val structsWithInstances = parsedFiles.map {
            it.first.accept(it.second)
            it.second.foundStructs.map { s ->
                val name = UwUName(*it.second.pkg + s.IDENTIFIER().text)

                Triple(s, UwUStruct(name, mutableListOf(), mutableListOf(), UwUConstructor.NullConstructor(UwUPrimitive.UwuVoid)), it.second)
            } to it.second
        }

        val files = mutableListOf<UwUFile>()

        for (item in structsWithInstances) {
            val structs = mutableListOf<UwUStruct>()
            for ((struct, instance, finder) in item.first) {
                val fieldsString = struct.nameTypePair().map { Pair(it.name.text, it.type.text) }
                val fields = fieldsString.mapIndexed { i, it ->
                    val type = finder.imports.find { im -> im.name.simpleName == it.second }
                        ?.run { UwUType.registry[this.name] }
                        ?: structsWithInstances.flatMap { it.first }.find { s -> s.second.name.simpleName == it.second }?.second
                    UwuField(it.first, type!!, i * 8)
                }
                instance.fields.addAll(fields)
                instance.constructor = UwUConstructor.NullConstructor(instance)

                val methods = struct.`fun`()
                for (method in methods) {
                    val name = method.name.text
                    val args = method.nameTypePair().map {
                        val type = finder.imports.find { im -> im.name.simpleName == it.type.text }
                            ?.run { UwUType.registry[this.name] }
                            ?: structsWithInstances.flatMap { v -> v.first }.find { s -> s.second.name.simpleName == it.type.text }?.second
                        it.name.text to type!!
                    }

//                val returnType = method.returnType?.run { structFinder.imports.find { im -> im.name.simpleName == this.text }?.run { UwUType.registry[this.name] } ?: structsWithInstances.find { s -> s.second.name.simpleName == this.text }?.second }
//                    ?: UwUPrimitive.UwuVoid

                    instance.methods.add(
                        UwULangMethod(
                            name, false, args, method,
                            finder.imports + structsWithInstances.flatMap { it.first }.map { UwUImport(it.second.name) })
                    )
                }
                structs.add(instance)
            }
            files.add(UwUFile(UwUName(*item.second.pkg), item.second.imports, structs))
        }

//        return UwUFile(
//            UwUName(*structFinder.pkg), structFinder.imports,
//            structsWithInstances.map { it.second })
        return files
    }

    data class UwULangMethod(override val name: String, override val static: Boolean,
                        override val arguments: List<Pair<String, UwUType>>,
                        /*override val returnType: UwUType,*/ private val node: RuleContext,
                        private val imports: List<UwUImport>) : UwUMethod {

        override fun invoke(obj: UwUObject, args: List<UwUObject>): UwUObject {
            val scope = ExecutionScope(null, arguments.mapIndexed { index, pair -> UwUVar(pair.first, args[index]) }.toMutableList(), mutableSetOf())

            val executor = StatementEvaluator(imports, scope, obj)

            val res = executor.exec(node)

            scope.freeVars()

            return res
        }
    }

    class StatementEvaluator(private val imports: List<UwUImport>, private var scope: ExecutionScope, private val obj: UwUObject) : UwULangBaseVisitor<Unit>() {
        private class ReturnException(val obj: UwUObject) : Throwable()

        fun exec(node: RuleContext): UwUObject {
            try {
                node.accept(this)
            } catch (e: ReturnException) {
                return e.obj
            }
            return nil
        }

        override fun visitFun(ctx: FunContext) {
            for (statement in ctx.multiStatement().statement()) {
                visitStatement(statement)
            }
        }

        override fun visitIfStatement(ctx: UwULangParser.IfStatementContext) {
            val condition = ExpressionVisitor(imports, scope, obj).visitExpression(ctx.expression())!!
            if ((condition as UwUObject.UwUStatic).value != 0L) {
                val oldScope = scope
                scope = ExecutionScope(scope, scope.variables.toMutableList(), mutableSetOf())
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
            val visitor = ExpressionVisitor(imports, scope, obj)
            while ((visitor.visitExpression(ctx.expression())!! as UwUObject.UwUStatic).value != 0L) {
                val oldScope = scope
                scope = ExecutionScope(scope, scope.variables.toMutableList(), mutableSetOf())
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
            val expr = ExpressionVisitor(imports, scope, obj).visitExpression(ctx.expression())!!
            scope.addedRoots.add(expr)
            val found = scope.variables.find { it.name == ctx.IDENTIFIER().text } ?: UwUVar(ctx.IDENTIFIER().text, nil).also { scope.variables.add(it) }
            found.value = expr
        }

        override fun visitFieldAssign(ctx: UwULangParser.FieldAssignContext) {
            val evaluator = ExpressionVisitor(imports, scope, obj)
            val res = evaluator.visitExpression(ctx.expression(0))!!
            val value = evaluator.visitExpression(ctx.expression(1))!!
            val type = res.type as UwUStruct
            val field = type.fields.find { it.name == ctx.IDENTIFIER().text }!!
            type.setField(res as UwUObject.UwURef, field, value)
        }

        override fun visitStatement(ctx: UwULangParser.StatementContext) {
            try {
                val asIf = ctx.ifStatement()
                val asWhile = ctx.whileLoop()
                val asVar = ctx.variableAssign()
                val asExpr = ctx.expression()
                val asReturn = ctx.RETURN()
                val asFieldAssign = ctx.fieldAssign()

                when {
                    asReturn != null -> {
                        val res = ExpressionVisitor(imports, scope, obj).visitExpression(ctx.expression())
                        throw ReturnException(res!!)
                    }
                    asIf != null -> visitIfStatement(asIf)
                    asWhile != null -> visitWhileLoop(asWhile)
                    asVar != null -> visitVariableAssign(asVar)
                    asExpr != null -> ExpressionVisitor(imports, scope, obj).visitExpression(asExpr)
                    asFieldAssign != null -> visitFieldAssign(asFieldAssign)
                }
            } catch (e: Exception) {
                println("Exception at line '${ctx.text}'")
                throw e
            }
        }
    }

    class ExpressionVisitor(private val imports: List<UwUImport>, private val eScope: ExecutionScope, private val obj: UwUObject) : UwULangBaseVisitor<UwUObject?>() {
        override fun defaultResult(): UwUObject? {
            return null
        }

        override fun visitFunctionInvocation(ctx: UwULangParser.FunctionInvocationContext): UwUObject {
            val funName = ctx.IDENTIFIER().symbol.text
            val args = ctx.expression().map { visitExpression(it)!! }
            val cls = imports.find { it.funName == funName }!!.name
            val instance = UwUType.registry[cls]!!

            return instance.findMethod(ctx.IDENTIFIER().text, args.map { it.type }).invoke(nil, args)
        }

        override fun visitExpression(ctx: UwULangParser.ExpressionContext): UwUObject? {
            try {
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
                val asCast = ctx.AS()

                return when {
                    asAddition != null -> {
                        val a = visitExpression(ctx.expression(0)) as UwUObject.UwUStatic
                        val b = visitExpression(ctx.expression(1)) as UwUObject.UwUStatic

                        if (a.type == UwUPrimitive.UwULong)
                            if (asAddition.PLUS() != null) UwUObject.UwUStatic(
                                a.value + b.value,
                                UwUPrimitive.UwULong
                            ) else UwUObject.UwUStatic(a.value - b.value, UwUPrimitive.UwULong)
                        else
                            if (asAddition.PLUS() != null) UwUObject.UwUStatic(
                                (a.value.double() + b.value.double()).long(),
                                UwUPrimitive.UwUDouble
                            ) else UwUObject.UwUStatic(
                                (a.value.double() - b.value.double()).long(),
                                UwUPrimitive.UwUDouble
                            )
                    }
                    asMultiplication != null -> {
                        val a = visitExpression(ctx.expression(0)) as UwUObject.UwUStatic
                        val b = visitExpression(ctx.expression(1)) as UwUObject.UwUStatic

                        if (a.type == UwUPrimitive.UwULong)
                            if (asMultiplication.TIMES() != null) UwUObject.UwUStatic(
                                a.value * b.value,
                                UwUPrimitive.UwULong
                            ) else UwUObject.UwUStatic(a.value * b.value, UwUPrimitive.UwULong)
                        else
                            if (asMultiplication.TIMES() != null) UwUObject.UwUStatic(
                                (a.value.double() / b.value.double()).long(),
                                UwUPrimitive.UwUDouble
                            ) else UwUObject.UwUStatic(
                                (a.value.double() / b.value.double()).long(),
                                UwUPrimitive.UwUDouble
                            )
                    }
                    asVariable != null -> {
                        if (asVariable.text == "this") obj else eScope.variables.find { it.name == ctx.IDENTIFIER().text }?.value
                            ?: imports.find { it.name.simpleName == ctx.IDENTIFIER().text }!!.run {
                                UwUConstructor.NullConstructor(UwUType.registry[this.name]!!).invoke(emptyList())
                            }
                    }
                    asFieldAccess != null -> {
                        visitExpression(ctx.expression(0)!!)!!
                            .run {
                                (type as UwUStruct).field(
                                    this as UwUObject.UwURef,
                                    (type as UwUStruct).fields.find { it.name == asFieldAccess.IDENTIFIER().text }!!
                                )
                            }
                    }
                    asMethodInv != null -> {
                        val obj = visitExpression(ctx.expression(0))!!
                        val args = asMethodInv.functionInvocation().expression().map { visitExpression(it)!! }
                        obj.type.findMethod(asMethodInv.functionInvocation().IDENTIFIER().text, args.map { it.type })
                            .invoke(obj, args)
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

                        val chars =
                            str.toCharArray().map { UwUObject.UwUStatic(it.code.toLong(), UwUPrimitive.UwUChar) }

                        val array =
                            UwUString.field(obj, UwUString.fields.find { it.name == "chars" }!!) as UwUObject.UwURef
                        UwUArray.setItems(array, chars)

                        obj
                    }
                    asNew != null -> {
                        val type = imports.find { it.name.simpleName == asNew.IDENTIFIER().text }!!
                            .run { UwUType.registry[this.name]!! }
                        val args = asNew.expression().map { visitExpression(it)!! }

                        type.constructor.invoke(args)
                    }
                    asCast != null -> {
                        val expr = visitExpression(ctx.expression(0))!!
                        val type = imports.find { it.name.simpleName == ctx.IDENTIFIER().text }!!
                            .run { UwUType.registry[this.name]!! }
                        require(expr.type == type)
                        expr
                    }
                    else -> nil
                }?.apply { if (this is UwUObject.UwURef) eScope.addRoot(this) }
            } catch (e: Exception) {
                println("Exception in expression ${ctx.text}")
                throw e
            }
        }
    }

    class UwUImport(val name: UwUName, val funName: String? = null) {
        override fun toString(): String {
            return name.names.joinToString(".")
        }
    }

    data class UwUVar(val name: String, var value: UwUObject)

    data class ExecutionScope(val parent: ExecutionScope?, val variables: MutableList<UwUVar>, val addedRoots: MutableSet<UwUObject>) {
        fun addRoot(root: UwUObject) {
            if (root is UwUObject.UwURef) {
                addedRoots.add(root)
                UwUMem.rootObjects.add(root.address)
            }
        }

        fun freeVars() {
            for (variable in addedRoots) {
                val addr = (variable as? UwUObject.UwURef)?.address ?: continue
                UwUMem.rootObjects.removeAll { it == addr }
            }
        }
    }
}

fun main() {
    // need to instantiate the structs so that they can be used
    UwUPrimitive.UwULong
    UwUPrimitive.UwUDouble
    stdlib.System

    val inp = """
        package com.github.bwahbwahbwoopstew.test;
        
        impowt uwu.System;
        impowt uwu.Wong;
        impowt uwu.Doubwe;
        impowt uwu.Awway;
        impowt uwu.Stwing;
        impowt owo.cowwections.Wist;
        
        stwuct Foo {
            static fuwn bwah() {
                wet w = Wist.cweate(Wong);
                
                mewt i = 0;
                whiwe (i.wessthan(24)) {
                    w.add(i);
                    i = i + 1;
                }
                
                i = 0;
                whiwe (i.wessthan(24)) {
                    System.pwintwn(w.get(i));
                    i = i + 1;
                }
            }
        }
    """.trimIndent()

    AntlerUwUParser().parseFiles(inp, File("src/main/kotlin/stdlib/Wist.uwu").readText())

    val resolvedType = UwUType.registry[UwUName("com", "github", "bwahbwahbwoopstew", "test", "Foo")] as UwUStruct
    val method = resolvedType.methods.find { it.name == "bwah" }!!
    val instance = resolvedType.constructor.invoke(emptyList())
    method.invoke(instance, emptyList())
    UwUMem.gc()
    require(UwUMem.rootObjects.isEmpty())
}
