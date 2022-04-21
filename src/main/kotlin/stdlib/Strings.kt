package stdlib

import UwUArray
import UwuField
import UwUName
import UwUStruct

object UwUString : UwUStruct(UwUName("uwu", "Stwing"), listOf(
    UwuField("chars", UwUArray[UwUPrimitive.UwUChar], 0)
), listOf(), UwUConstructor.NativeConstructor(listOf("size" to UwUPrimitive.UwULong)) { args ->
    val obj = UwUConstructor.NullConstructor(UwUString).invoke(emptyList()) as UwUObject.UwURef
    val array = UwUArray[UwUPrimitive.UwUChar].constructor.invoke(args) as UwUObject.UwURef  // args already has size in position 0
    UwUString.setField(obj, UwUString.fields.find { it.name == "chars" }!!, array)
    obj
})
