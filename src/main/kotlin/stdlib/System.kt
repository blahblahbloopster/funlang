package stdlib

import UwUArray
import UwUMem.nil
import UwUName
import UwUStruct

object System : UwUStruct(UwUName("uwu", "System"), mutableListOf(), mutableListOf(
    UwUMethod.NativeMethod("pwintwn", listOf("str" to UwUString), UwUPrimitive.UwuVoid, true) { _, b ->
        val charsArray = UwUString.field(b[0] as UwUObject.UwURef, UwUString.fields.find { it.name == "chars" }!!)
        val charObjects = UwUArray[UwUPrimitive.UwUChar].items(charsArray as UwUObject.UwURef)
        val str = charObjects.map { (it as UwUObject.UwUStatic).value.toInt().toChar() }.joinToString("")
        println(str)
        nil
    },
    UwUMethod.NativeMethod("pwintwn", listOf("num" to UwUPrimitive.UwULong), UwUPrimitive.UwuVoid, true) { _, b ->
        println((b[0] as UwUObject.UwUStatic).value)
        nil
    },
    UwUMethod.NativeMethod("gc", emptyList(), UwUPrimitive.UwuVoid, true) { _, _ ->
        UwUMem.gc()
        nil
    }
), UwUConstructor.NativeConstructor(emptyList()) { throw UnsupportedOperationException() })
