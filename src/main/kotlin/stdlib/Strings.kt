package stdlib

import UwUArray
import UwUMem
import UwUField
import UwUName
import UwUStruct
import UwUStructField

object UwUString : UwUStruct(UwUName("uwu", "Stwing"), mutableListOf(
    UwUStructField("chars", UwUArray, 0)
), mutableListOf(), mutableListOf(UwUConstructor.NativeConstructor(listOf("size" to UwUPrimitive.UwULong)) { args ->
    val array = UwUArray.constructors[0].invoke(listOf(UwUPrimitive.UwUChar.constructors[0].invoke(listOf()), args[0])) as UwUObject.UwURef  // args already has size in position 0
    UwUMem.rootObjects.add(array.address)
    val obj = UwUConstructor.NullConstructor(UwUString).invoke(emptyList()) as UwUObject.UwURef
    UwUMem.rootObjects.add(obj.address)
    UwUString.field(obj, "chars", array)
    UwUMem.rootObjects.remove(array.address)
    UwUMem.rootObjects.remove(obj.address)
    obj
}))
