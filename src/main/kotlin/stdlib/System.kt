package stdlib

import UwUArray
import UwUMem.nil
import UwUName
import UwUPrimitive.UwUDouble.double
import UwUStruct

object System : UwUStruct(UwUName("uwu", "System"), mutableListOf(), mutableListOf(
    UwUMethod.NativeMethod("pwintwn", listOf("str" to UwUString), true) { _, b ->
        val charsArray = UwUString.field(b[0] as UwUObject.UwURef, "chars")
        val charObjects = UwUArray.items(charsArray as UwUObject.UwURef)
        val str = charObjects.map { (it as UwUObject.UwUStatic).value.toInt().toChar() }.joinToString("")
        println(str)
        nil
    },
    UwUMethod.NativeMethod("pwintwn", listOf("num" to UwUPrimitive.UwULong),true) { _, b ->
        println((b[0] as UwUObject.UwUStatic).value)
        nil
    },
    UwUMethod.NativeMethod("pwintwn", listOf("num" to UwUPrimitive.UwUDouble),true) { _, b ->
        println((b[0] as UwUObject.UwUStatic).value.double())
        nil
    },
    UwUMethod.NativeMethod("gc", emptyList(), true) { _, _ ->
        UwUMem.gc()
        nil
    }
), mutableListOf(UwUConstructor.NativeConstructor(emptyList()) { throw UnsupportedOperationException() }))
