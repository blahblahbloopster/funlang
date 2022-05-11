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
            if (qualifiedName.names.first() == "javacompat") {
                JavaType(Class.forName(qualifiedName.names.drop(1).joinToString(".")))
            }
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

    private fun resolveType(name: String, structs: List<UwUStruct>, imports: List<UwUImport>): UwUType? {
        return structs.find { it.name.simpleName == name } ?: imports.find { it.name.simpleName == name }?.name?.run {
//            if (this.names.first() == "javacompat")
            UwUType.registry[this]
        }
    }

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

                Triple(s, UwUStruct(name, mutableListOf(), mutableListOf(), mutableListOf()), it.second)
            } to it.second
        }

        val files = mutableListOf<UwUFile>()

        for (item in structsWithInstances) {
            val structs = mutableListOf<UwUStruct>()
            for ((struct, instance, finder) in item.first) {
                val fieldsString = struct.nameTypePair().map { Pair(it.name.text, it.type.text) }
                val fields = fieldsString.mapIndexed { i, it ->
                    val type = resolveType(it.second, structsWithInstances.flatMap { it.first.map { v -> v.second } }, finder.imports)
//                    val type = finder.imports.find { im -> im.name.simpleName == it.second }
//                        ?.run { UwUType.registry[this.name] }
//                        ?: structsWithInstances.flatMap { it.first }.find { s -> s.second.name.simpleName == it.second }?.second
                    UwUStructField(it.first, type!!, i * 8)
                }
                instance.fields.addAll(fields)
                instance.constructors.add(UwUConstructor.NullConstructor(instance))

                val methods = struct.`fun`()
                for (method in methods) {
                    val name = method.name.text
                    val args = method.nameTypePair().map {
                        val type = resolveType(it.type.text, structsWithInstances.flatMap { it.first.map { v -> v.second } }, finder.imports)
//                        val type = finder.imports.find { im -> im.name.simpleName == it.type.text }
//                            ?.run { UwUType.registry[this.name] }
//                            ?: structsWithInstances.flatMap { v -> v.first }.find { s -> s.second.name.simpleName == it.type.text }?.second
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

        override fun visitForLoop(ctx: UwULangParser.ForLoopContext) {
            val old = scope
            scope = ExecutionScope(scope, scope.variables.toMutableList(), mutableSetOf())
            val visitor = ExpressionVisitor(imports, scope, obj)
            visitStatement(ctx.init)

            try {
                while ((visitor.visitExpression(ctx.condition) as UwUObject.UwUStatic).value != 0L) {
                    for (s in ctx.braceBlock().statement()) {
                        visitStatement(s)
                    }
                    visitStatement(ctx.each)
                }
            } finally {
                scope.freeVars()
                scope = old
            }
        }

        override fun visitVariableAssign(ctx: UwULangParser.VariableAssignContext) {
            val expr = ExpressionVisitor(imports, scope, obj).visitExpression(ctx.expression())!!
            scope.addedRoots.add(expr)
            val found = scope.variables.find { it.name == ctx.IDENTIFIER().text } ?: obj.type.fields.find { it.name == ctx.IDENTIFIER().text }?.run { set(obj, expr); return } ?: UwUVar(ctx.IDENTIFIER().text, nil).also { scope.variables.add(it) }
            found.value = expr
        }

        override fun visitFieldAssign(ctx: UwULangParser.FieldAssignContext) {
            val evaluator = ExpressionVisitor(imports, scope, obj)
            val res = evaluator.visitExpression(ctx.expression(0))!!
            val value = evaluator.visitExpression(ctx.expression(1))!!
            val type = res.type as UwUStruct
            type.field(res, ctx.IDENTIFIER().text, value)
        }

        override fun visitStatement(ctx: UwULangParser.StatementContext) {
            try {
                val asIf = ctx.ifStatement()
                val asWhile = ctx.whileLoop()
                val asVar = ctx.variableAssign()
                val asExpr = ctx.expression()
                val asReturn = ctx.RETURN()
                val asFieldAssign = ctx.fieldAssign()
                val asForLoop = ctx.forLoop()

                when {
                    asReturn != null -> {
                        val expr = ctx.expression()
                        if (expr != null) {
                            val res = ExpressionVisitor(imports, scope, obj).visitExpression(ctx.expression())
                            throw ReturnException(res!!)
                        } else {
                            throw ReturnException(nil)
                        }
                    }
                    asIf != null -> visitIfStatement(asIf)
                    asWhile != null -> visitWhileLoop(asWhile)
                    asVar != null -> visitVariableAssign(asVar)
                    asExpr != null -> ExpressionVisitor(imports, scope, obj).visitExpression(asExpr)
                    asFieldAssign != null -> visitFieldAssign(asFieldAssign)
                    asForLoop != null -> visitForLoop(asForLoop)
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
            // function imports aren't supported yet, so this is commented out for now
            // TODO: function imports
//            val cls = imports.find { it.funName == funName }!!.name
//            val instance = UwUType.registry[cls]!!
//
//            return instance.findMethod(ctx.IDENTIFIER().text, args.map { it.type }).invoke(nil, args)
            return obj.type.findMethod(funName, args.map { it.type }).invoke(obj, args)
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
                val asComp = ctx.compOp()

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
                        val name = asVariable.text
                        val asThis = if (name == "this") obj else null
                        val asLocalVar = eScope.variables.find { it.name == name }?.value
                        val asObjectField = obj.type.fieldOrNull(obj, name)
                        // TODO: also search in the file
                        val asImportedName = imports.find { it.name.simpleName == name }?.run { UwUType.registry[this.name]!!.nullConstructor.invoke(emptyList()) }

                        return asThis ?: asLocalVar ?: asObjectField ?: asImportedName!!
                    }
                    asFieldAccess != null -> {
                        visitExpression(ctx.expression(0)!!)!!
                            .run {
                                type.field(this, asFieldAccess.IDENTIFIER().text)
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
                        val size = UwUPrimitive.UwULong.constructor(emptyList())
                            .apply { (this as UwUObject.UwUStatic).value = str.length.toLong() }
                        val obj = UwUString.constructor(listOf(size)) as UwUObject.UwURef
                        eScope.addRoot(obj)

                        val chars =
                            str.toCharArray().map { UwUObject.UwUStatic(it.code.toLong(), UwUPrimitive.UwUChar) }

                        val array = UwUString.field(obj, "chars") as UwUObject.UwURef
                        UwUArray.setItems(array, chars)

                        obj
                    }
                    asNew != null -> {
                        val type = imports.find { it.name.simpleName == asNew.IDENTIFIER().text }!!
                            .run { UwUType.registry[this.name]!! }
                        val args = asNew.expression().map { visitExpression(it)!! }

                        type.constructor(args)
                    }
                    asCast != null -> {
                        val expr = visitExpression(ctx.expression(0))!!
                        val type = imports.find { it.name.simpleName == ctx.IDENTIFIER().text }!!
                            .run { UwUType.registry[this.name]!! }
                        require(expr.type == type)
                        expr
                    }
                    asComp != null -> {
                        val a = visitExpression(ctx.expression(0))!!
                        val b = visitExpression(ctx.expression(1))!!

                        val aLong = (a as? UwUObject.UwUStatic)?.value
                        val bLong = (b as? UwUObject.UwUStatic)?.value

                        UwUObject.UwUStatic(if (when {
                            asComp.EQUALS() != null -> comp(a, b, aLong, bLong, { c, d -> c == d }, { c, d -> c == d }, { c, d -> c == d }, { c, d -> c == d }, { c, d -> if (c is UwUObject.UwURef) { c.address == (d as? UwUObject.UwURef)?.address } else { c == d /* TODO: java object compatibility */} })
                            asComp.GREATERTHAN() != null -> comp(a, b, aLong, bLong, { c, d -> c > d }, { c, d -> c > d }, { c, d -> c > d }, { c, d -> c > d }, { _, _ -> throw UnsupportedOperationException() })
                            asComp.GREATERTHANEQUALS() != null -> comp(a, b, aLong, bLong, { c, d -> c >= d }, { c, d -> c >= d }, { c, d -> c >= d }, { c, d -> c >= d }, { _, _ -> throw UnsupportedOperationException() })
                            asComp.LESSTHAN() != null -> comp(a, b, aLong, bLong, { c, d -> c < d }, { c, d -> c < d }, { c, d -> c < d }, { c, d -> c < d }, { _, _ -> throw UnsupportedOperationException() })
                            asComp.LESSTHANEQUALS() != null -> comp(a, b, aLong, bLong, { c, d -> c <= d }, { c, d -> c <= d }, { c, d -> c <= d }, { c, d -> c <= d }, { _, _ -> throw UnsupportedOperationException() })
                            else -> throw RuntimeException("w h a t")
                        }) 1L else 0L, UwUPrimitive.UwUBoolean)
                    }
                    else -> nil
                }?.apply { if (this is UwUObject.UwURef) eScope.addRoot(this) }
            } catch (e: Exception) {
                println("Exception in expression ${ctx.text}")
                throw e
            }
        }

        // TODO: comparing different types, comparing to null
        private inline fun comp(a: UwUObject, b: UwUObject, aLong: Long?, bLong: Long?, long: (Long, Long) -> Boolean, double: (Double, Double) -> Boolean, boolean: (Boolean, Boolean) -> Boolean, char: (Char, Char) -> Boolean, obj: (UwUObject, UwUObject) -> Boolean): Boolean {
            return when (a.type) {
                UwUPrimitive.UwULong -> long(aLong!!, bLong!!)
                UwUPrimitive.UwUDouble -> double(aLong!!.double(), bLong!!.double())
                UwUPrimitive.UwUBoolean -> boolean(aLong!! != 0L, bLong!! != 0L)
                UwUPrimitive.UwUChar -> char(aLong!!.toInt().toChar(), bLong!!.toInt().toChar())
                else -> obj(a, b)
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
        
        impowt owo.cowwections.Wist;
        impowt uwu.System;
        impowt uwu.Wong;
        
        stwuct Foo {
            static fuwn bwah() {
                wet wist = Wist.cweate(Wong);
                fow (mewt i = 0; i < 10; i = i + 1;) {
                    wist.add(i * 5);
                }
                
                wist.wemove(5);
                
                fow (mewt i = 0; i < wist.size; i = i + 1;) {
                    System.pwintwn(wist.get(i));
                }
            }
        }
    """.trimIndent()

    AntlerUwUParser().parseFiles(inp, File("src/main/kotlin/stdlib/Wist.uwu").readText())

    val resolvedType = UwUType.registry[UwUName("com", "github", "bwahbwahbwoopstew", "test", "Foo")] as UwUStruct
    val method = resolvedType.methods.find { it.name == "bwah" }!!
    val instance = resolvedType.constructor(emptyList())
    method.invoke(instance, emptyList())
    UwUMem.gc()
    require(UwUMem.rootObjects.isEmpty())
}
