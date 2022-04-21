import UwUMem.nil
import UwUPrimitive.UwUDouble.long
import org.antlr.v4.runtime.CodePointBuffer
import org.antlr.v4.runtime.CodePointCharStream
import org.antlr.v4.runtime.CommonTokenStream
import stdlib.UwUString
import java.nio.CharBuffer

class AntlerUwUParser {
//    class Listener : UwULangListener {}

    class ExpressionVisitor(val imports: List<UwUParser.UwUImport>, val eScope: UwUInterpreter.ExecutionScope) : UwULangBaseVisitor<UwUObject?>() {
        override fun defaultResult(): UwUObject? {
            return null
        }

        override fun visitFieldAccess(ctx: UwULangParser.FieldAccessContext): UwUObject? {
            TODO()
        }

        override fun visitFunctionInvocation(ctx: UwULangParser.FunctionInvocationContext): UwUObject? {
            val funName = ctx.IDENTIFIER().symbol.text
            val args = ctx.expression().map { visitExpression(it)!! }
            val cls = imports.find { it.funName == funName }!!.name
            val instance = UwUType.registry[cls]!!

            return instance.methods.find { it.name == funName }!!.invoke(nil, args)
        }

        override fun visitMethodInvocation(ctx: UwULangParser.MethodInvocationContext): UwUObject? {
            TODO()
        }

        override fun visitAddOp(ctx: UwULangParser.AddOpContext): UwUObject? {
            TODO()
        }

        override fun visitMulOp(ctx: UwULangParser.MulOpContext): UwUObject? {
            TODO()
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

            return when {
                asAddition != null -> TODO()
                asMultiplication != null -> TODO()
                asVariable != null -> eScope.variables.find { it.name == ctx.IDENTIFIER().text }!!.value
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
                else -> nil
            }
        }
    }
}

fun main() {
//    val inp = """impowt uwu.System.pwintwn;
//
//stwuct Blah {
//    foo: Wong,
//    bar: Doubwe;
//
//    fuwn testFun(arg1: Wong) {
//        pwintwn("iowejfioewoif");
//    }
//}""".trimIndent()

    val inp = """pwintwn("w h a t")"""

    val lexed = UwULangLexer(CodePointCharStream.fromBuffer(
        CodePointBuffer.withChars(CharBuffer.wrap(inp.toCharArray()))
    ))

    val parsed = UwULangParser(CommonTokenStream(lexed))
//    val file = parsed.file()

//    val listener = object : UwULangBaseListener() {
//        override fun enterEveryRule(ctx: ParserRuleContext?) {
//            println(ctx?.javaClass)
//        }
//    }

//    ParseTreeWalker.DEFAULT.walk(object : UwULangBaseListener() {}, file)
//    println(file.accept(AntlerUwUParser.ExpressionVisitor()))
    val expr = parsed.expression()
    val scope = UwUInterpreter.ExecutionScope(null, mutableListOf(), mutableSetOf())
    AntlerUwUParser.ExpressionVisitor(listOf(UwUParser.UwUImport(stdlib.System.name, "pwintwn")), scope).visit(expr)
}
