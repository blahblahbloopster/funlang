package stdlib

import UwUArray
import UwUMem.nil
import UwUName
import UwUStruct

object System : UwUStruct(UwUName("uwu", "system"), mutableListOf(), mutableListOf(
    UwUMethod.NativeMethod("pwintwn", listOf("str" to UwUString), UwUPrimitive.UwuVoid, true) { _, b ->
        val charsArray = UwUString.field(b[0] as UwUObject.UwURef, UwUString.fields.find { it.name == "chars" }!!)
        val charObjects = UwUArray[UwUPrimitive.UwUChar].items(charsArray as UwUObject.UwURef)
        val str = charObjects.map { (it as UwUObject.UwUStatic).value.toInt().toChar() }.joinToString("")
        println(str)
        nil
    }
), UwUConstructor.NativeConstructor(emptyList()) { throw UnsupportedOperationException() })
