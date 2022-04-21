import UwUMem.currentFlag
import UwUMem.nil
import UwUPrimitive.UwUDouble.long
import stdlib.UwUString
import java.nio.ByteBuffer

class UwUInterpreter {
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

    fun evaluateExpression(expr: UwUParser.ExpressionNode, scope: ExecutionScope, level: Int = 0): UwUObject {
        return when (expr) {
            is UwUParser.ExpressionNode.ConstantNode -> when (expr.type) {
                UwUString -> {
                    val size = UwUPrimitive.UwULong.constructor.invoke(emptyList())
                        .apply { (this as UwUObject.UwUStatic).value = (expr.value as String).length.toLong() }
                    val obj = UwUString.constructor.invoke(listOf(size)) as UwUObject.UwURef
                    scope.addRoot(obj)

                    val chars = (expr.value as String).toCharArray().map { UwUObject.UwUStatic(it.code.toLong(), UwUPrimitive.UwUChar) }

                    val array = UwUString.field(obj, UwUString.fields.find { it.name == "chars" }!!) as UwUObject.UwURef
                    UwUArray[UwUPrimitive.UwUChar].setItems(array, chars)

                    obj
                }
                UwUPrimitive.UwULong -> UwUPrimitive.UwULong.constructor.invoke(emptyList()).apply { (this as UwUObject.UwUStatic).value = expr.value as Long }
                UwUPrimitive.UwUDouble -> UwUPrimitive.UwUDouble.constructor.invoke(emptyList()).apply { (this as UwUObject.UwUStatic).value = (expr.value as Double).long() }
                else -> TODO()
            }
            is UwUParser.ExpressionNode.FieldGetNode -> evaluateExpression(expr.obj, scope, level + 1).run { (type as UwUStruct).field(this as UwUObject.UwURef, expr.field).also { scope.addRoot(it) } }
            is UwUParser.ExpressionNode.MethodInvokeNode -> expr.method.invoke(evaluateExpression(expr.obj, scope), expr.args.map { evaluateExpression(it, scope, level + 1).also { a -> scope.addRoot(a) } })
            is UwUParser.ExpressionNode.StaticMethodInvokeNode -> expr.method.invoke(nil, expr.args.map { evaluateExpression(it, scope, level + 1).also { a -> scope.addRoot(a) } }).also { scope.addRoot(it) }
            is UwUParser.ExpressionNode.VariableNode -> scope.variables.find { it.name == expr.variable.name }!!.value
        }
    }
}
