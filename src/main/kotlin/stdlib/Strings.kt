package stdlib

import UwUArray
import UwUMem
import UwuField
import UwUName
import UwUStruct

object UwUString : UwUStruct(UwUName("uwu", "Stwing"), mutableListOf(
    UwuField("chars", UwUArray, 0)
), mutableListOf(), UwUConstructor.NativeConstructor(listOf("size" to UwUPrimitive.UwULong)) { args ->
    val array = UwUArray.constructor.invoke(listOf(UwUPrimitive.UwUChar.constructor.invoke(listOf()), args[0])) as UwUObject.UwURef  // args already has size in position 0
    UwUMem.rootObjects.add(array.address)
    val obj = UwUConstructor.NullConstructor(UwUString).invoke(emptyList()) as UwUObject.UwURef
    UwUMem.rootObjects.add(obj.address)
    UwUString.setField(obj, UwUString.fields.find { it.name == "chars" }!!, array)
    UwUMem.rootObjects.remove(array.address)
    UwUMem.rootObjects.remove(obj.address)
    obj
})
