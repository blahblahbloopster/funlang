import UwUMem.malloc
import UwUMem.nil

sealed class UwUType(val name: UwUName) {
    abstract val methods: List<UwUMethod>
    abstract val constructor: UwUConstructor
    abstract val isStatic: Boolean

    fun getObj(data: LongArray, offset: Int): UwUObject {
        val value = data[offset]
        return if (isStatic) {
            UwUObject.UwUStatic(value, this)
        } else {
            val block = UwUMem.lowestAllocated(value) ?: return nil
            UwUObject.UwURef(block, this)
        }
    }

    fun putObj(data: LongArray, offset: Int, obj: UwUObject) {
        if (obj is UwUObject.UwUStatic) {
            data[offset] = obj.value
        } else if (obj is UwUObject.UwURef) {
            data[offset] = obj.address.area.first.toLong()
        }
    }

    abstract fun free(obj: UwUObject)

    companion object {
        val registry = mutableMapOf<UwUName, UwUType>()
    }

    init {
        registry[name] = this
    }
}

class UwuField(val name: String, val type: UwUType, val offset: Int)

interface UwUMethod {
    val name: String
    val arguments: List<Pair<String, UwUType>>
    val returnType: UwUType
    val static: Boolean

    fun invoke(obj: UwUObject, args: List<UwUObject>): UwUObject

    class NativeMethod(override val name: String,
                       override val arguments: List<Pair<String, UwUType>>,
                       override val returnType: UwUType,
                       override val static: Boolean = false,
                       private val lambda: (UwUObject, List<UwUObject>) -> UwUObject) : UwUMethod {
        override fun invoke(obj: UwUObject, args: List<UwUObject>): UwUObject = lambda(obj, args)
    }
}

interface UwUConstructor {
    val arguments: List<Pair<String, UwUType>>

    fun invoke(args: List<UwUObject>): UwUObject

    class NativeConstructor(
        override val arguments: List<Pair<String, UwUType>>,
        private val lambda: (List<UwUObject>) -> UwUObject
    ) : UwUConstructor {
        override fun invoke(args: List<UwUObject>): UwUObject = lambda(args)
    }

    class NullConstructor(private val type: UwUType) : UwUConstructor {
        override val arguments: List<Pair<String, UwUType>> = emptyList()
        override fun invoke(args: List<UwUObject>): UwUObject {
            if (type.isStatic) {
                return UwUObject.UwUStatic(-1L, type)
            } else if (type is UwUStruct) {
                val obj = malloc(type.sizeWords, type)
                UwUMem.data.fill(-1L, obj.area.first, obj.area.last + 1)
                return UwUObject.UwURef(obj, type)
            }
            throw NotImplementedError("No default constructor for ${type.name}!")
        }
    }
}

object UwUMem {
    // 8 MiB ought to be enough for anybody
    val data = LongArray(1024)

    val tree = MemoryBlock(data.indices)

    class MemoryBlock(val area: IntRange) {
        var refs: Int = 0
        var left: MemoryBlock? = null
        var right: MemoryBlock? = null
        var available: Boolean = true
        val size get() = area.last + 1 - area.first
        var type: UwUType = UwUPrimitive.UwuVoid
        var allocationTime = 0L

        fun findAllocated(): List<MemoryBlock> {
            return if (left == null && right == null) {
                listOf(this)
            } else {
                (left?.findAllocated() ?: emptyList()) + (right?.findAllocated() ?: emptyList())
            }
        }

        fun free() {
            left?.free()
            right?.free()
            left = null
            right = null
            available = true
            type = UwUPrimitive.UwuVoid
            allocationTime = 0
            refs = 0
        }

        fun findFreeable(): List<MemoryBlock> {
            return if (left == null && right == null && available) {
                listOf(this)
            } else if (!available) {
                if (refs == 0) listOf(this) else emptyList()
            } else {
                val l = left?.findFreeable() ?: emptyList()
                val r = right?.findFreeable() ?: emptyList()
                l + r
            }
        }

        fun freeEmpty(): Boolean {
            return if (left == null && right == null && available) {
                true
            } else if (!available) {
                refs == 0 && (System.nanoTime() - allocationTime) > 1000_000L
            } else {
                val l = left?.freeEmpty() != false
                val r = right?.freeEmpty() != false
                if (l) left = null
                if (r) right = null
                l && r
            }
        }

        fun freeEmpty2(): Boolean {
            return if (left == null && right == null && available) {
                true
            } else if (!available) {
                false
            } else {
                val l = left?.freeEmpty2() != false
                val r = right?.freeEmpty2() != false
                if (l) {
                    left?.free()
                    left = null
                }
                if (r) {
                    right?.free()
                    right = null
                }
                l && r
            }
        }

        fun lowestAllocated(start: Long): MemoryBlock? {
            return if (area.first.toLong() == start) {
                if (left == null) this else left!!.lowestAllocated(start)
            } else if (start in area) {
                if (left?.area?.contains(start) == true) {
                    left?.lowestAllocated(start)
                } else {
                    right?.lowestAllocated(start)
                }
            } else {
                null
            }
        }

        override fun toString(): String {
            return "$type at $area with $refs refs"
        }

        fun incRefs() {
//            if (inSafetyZone) {
//                inSafetyZone = false
//                return
//            }
            refs++
        }

        fun findFree(sizeWords: Int, type: UwUType): MemoryBlock? {
            val bucketSize = (sizeWords shl 1).takeHighestOneBit()  // TODO: make this smorter
            val midpoint = (area.first + area.last + 1) / 2
            return when {
                !available -> null
                size == bucketSize && left == null && right == null -> this.apply { allocationTime = System.nanoTime(); available = false; this.type = type; refs = 0 }
                size < bucketSize -> null
                size > bucketSize -> {
                    if (left == null) MemoryBlock(area.first until midpoint).also { left = it }
                    left?.findFree(sizeWords, type)?.also { return it }
                    if (right == null) MemoryBlock(midpoint..area.last).also { right = it }
                    right?.findFree(sizeWords, type)?.also { return it }
                    null
                }
                 else -> null
            }
        }
    }

    private fun gcRound() {
        val freeable = tree.findAllocated().filter { it.refs == 0 }.sortedBy { it.allocationTime }.run { take(size / 2) }
        for (item in freeable) {
            item.type.free(UwUObject.UwURef(item, item.type))
//            item.free()
        }
        tree.freeEmpty2()
    }

    fun gc() {
//        gcRound()
//        gcRound()
        for (item in tree.findFreeable()) {
            if (item.refs != 0) continue
            item.type.free(UwUObject.UwURef(item, item.type))
        }
        tree.freeEmpty()
    }

    fun gcAll() {
//        tree.freeEmpty()
        gc()
    }

    fun malloc(sizeWords: Int, type: UwUType): MemoryBlock {
        return tree.findFree(sizeWords, type) ?: run { println("Out of heap space, running GC"); gc() }.run { tree.findFree(sizeWords, type)!! }
    }

    fun lowestAllocated(start: Long): MemoryBlock? {
        return tree.lowestAllocated(start)
    }

    val nil = UwUObject.UwUStatic(0L, UwUPrimitive.UwuVoid)
}

sealed interface UwUObject {
    val type: UwUType

    data class UwURef(val address: UwUMem.MemoryBlock, override val type: UwUType) : UwUObject

    data class UwUStatic(var value: Long, override val type: UwUType) : UwUObject
}

sealed class UwUPrimitive(name: UwUName) : UwUType(name) {
    override val isStatic: Boolean = true
    override fun free(obj: UwUObject) {}

    object UwuVoid : UwUPrimitive(UwUName("uwu", "Void")) {
        override val methods: List<UwUMethod> = emptyList()
        override val constructor: UwUConstructor = UwUConstructor.NativeConstructor(emptyList()) { nil }
    }
    object UwULong : UwUPrimitive(UwUName("uwu", "Long")) {
        override val constructor: UwUConstructor = UwUConstructor.NativeConstructor(emptyList()) { UwUObject.UwUStatic(0L, UwULong) }
        override val methods = listOf(
            UwUMethod.NativeMethod("pwus", listOf("b" to UwULong), UwULong) { a, b -> UwUObject.UwUStatic((a as UwUObject.UwUStatic).value + (b[0] as UwUObject.UwUStatic).value, UwULong) },
            UwUMethod.NativeMethod("minus", listOf("b" to UwULong), UwULong) { a, b -> UwUObject.UwUStatic((a as UwUObject.UwUStatic).value - (b[0] as UwUObject.UwUStatic).value, UwULong) },
            UwUMethod.NativeMethod("times", listOf("b" to UwULong), UwULong) { a, b -> UwUObject.UwUStatic((a as UwUObject.UwUStatic).value * (b[0] as UwUObject.UwUStatic).value, UwULong) },
            UwUMethod.NativeMethod("divide", listOf("b" to UwULong), UwULong) { a, b -> UwUObject.UwUStatic((a as UwUObject.UwUStatic).value / (b[0] as UwUObject.UwUStatic).value, UwULong) },
            UwUMethod.NativeMethod("eqwaws", listOf("b" to UwULong), UwUBoolean) { a, b -> UwUObject.UwUStatic(if ((a as UwUObject.UwUStatic).value == (b[0] as UwUObject.UwUStatic).value) 1L else 0L, UwUBoolean) },
            UwUMethod.NativeMethod("wessthan", listOf("b" to UwULong), UwUBoolean) { a, b -> UwUObject.UwUStatic(if ((a as UwUObject.UwUStatic).value < (b[0] as UwUObject.UwUStatic).value) 1L else 0L, UwUBoolean) },
        )
    }
    object UwUDouble : UwUPrimitive(UwUName("uwu", "Double")) {
        override val constructor: UwUConstructor = UwUConstructor.NativeConstructor(emptyList()) { UwUObject.UwUStatic(0L, UwUDouble) }
        private fun Long.double() = java.lang.Double.longBitsToDouble(this)
        fun Double.long() = java.lang.Double.doubleToLongBits(this)

        override val methods = listOf(
            UwUMethod.NativeMethod("plus", listOf("b" to UwUDouble), UwUDouble) { a, b -> UwUObject.UwUStatic(((a as UwUObject.UwUStatic).value.double() + (b[0] as UwUObject.UwUStatic).value.double()).long(), UwUDouble) },
            UwUMethod.NativeMethod("minus", listOf("b" to UwUDouble), UwUDouble) { a, b -> UwUObject.UwUStatic(((a as UwUObject.UwUStatic).value.double() - (b[0] as UwUObject.UwUStatic).value.double()).long(), UwUDouble) },
            UwUMethod.NativeMethod("times", listOf("b" to UwUDouble), UwUDouble) { a, b -> UwUObject.UwUStatic(((a as UwUObject.UwUStatic).value.double() * (b[0] as UwUObject.UwUStatic).value.double()).long(), UwUDouble) },
            UwUMethod.NativeMethod("divide", listOf("b" to UwUDouble), UwUDouble) { a, b -> UwUObject.UwUStatic(((a as UwUObject.UwUStatic).value.double() / (b[0] as UwUObject.UwUStatic).value.double()).long(), UwUDouble) },
        )
    }

    object UwUChar : UwUPrimitive(UwUName("uwu", "Char")) {
        override val constructor: UwUConstructor = UwUConstructor.NativeConstructor(emptyList()) { UwUObject.UwUStatic(0L, UwUChar) }
        override val methods: List<UwUMethod> = emptyList()
    }

    object UwUBoolean : UwUPrimitive(UwUName("uwu", "Boolean")) {
        override val constructor: UwUConstructor = UwUConstructor.NativeConstructor(emptyList()) { UwUObject.UwUStatic(0L, UwUBoolean) }
        override val methods: List<UwUMethod> = emptyList()
    }
}

class UwUName(vararg val names: String) {
    val simpleName = names.last()
}

open class UwUStruct(
    name: UwUName,
    val fields: List<UwuField>,
    override val methods: List<UwUMethod>,
    override val constructor: UwUConstructor
) : UwUType(name) {
    override val isStatic: Boolean = false
    val sizeWords = (fields.maxOfOrNull { it.offset } ?: -1) + 1

    override fun free(obj: UwUObject) {
        for (item in fields) {
            val o = field(obj as UwUObject.UwURef, item)
            (o as? UwUObject.UwURef)?.run { address.refs-- }
        }
    }

    fun field(obj: UwUObject.UwURef, field: UwuField): UwUObject {
        return field.type.getObj(UwUMem.data, obj.address.area.first + field.offset)
    }

    fun setField(obj: UwUObject.UwURef, field: UwuField, value: UwUObject) {
        if (value is UwUObject.UwURef) value.address.incRefs()
        val old = field(obj, field)
        if (old is UwUObject.UwURef) old.address.refs--
        field.type.putObj(UwUMem.data, obj.address.area.first + field.offset, value)
    }
}

class UwUArray private constructor(val type: UwUType) : UwUType(UwUName("uwu", "arrays", "${type.name.simpleName}Array")) {
    companion object {
        private val registry = mutableMapOf<UwUType, UwUArray>()

        operator fun get(type: UwUType): UwUArray {
            return registry.getOrPut(type) { UwUArray(type) }
        }
    }

    override val methods = listOf(
        UwUMethod.NativeMethod("get", listOf("index" to UwUPrimitive.UwULong), type) { a, b ->
            val index = (b[0] as UwUObject.UwUStatic).value
            val addr = (a as UwUObject.UwURef).address.area.first + index + 1
            type.getObj(UwUMem.data, addr.toInt())
        },
        UwUMethod.NativeMethod("set", listOf("index" to UwUPrimitive.UwULong, "obj" to type), type) { a, b ->
            val index = (b[0] as UwUObject.UwUStatic).value
            val toPut = b[1]
            val addr = (a as UwUObject.UwURef).address.area.first + index + 1
            val old = type.getObj(UwUMem.data, addr.toInt())
            if (old is UwUObject.UwURef) old.address.refs--
            type.putObj(UwUMem.data, addr.toInt(), toPut)
            if (toPut is UwUObject.UwURef) toPut.address.incRefs()
            nil
        },
        UwUMethod.NativeMethod("getSize", emptyList(), UwUPrimitive.UwULong) { a, b ->
            UwUPrimitive.UwULong.getObj(UwUMem.data, (a as UwUObject.UwURef).address.area.first)
        }
    )
    override val constructor: UwUConstructor = UwUConstructor.NativeConstructor(listOf("size" to UwUPrimitive.UwULong)) { args ->
        val size = (args[0] as UwUObject.UwUStatic).value.toInt()
        val region = malloc(size + 1, this)
        UwUMem.data[region.area.first] = size.toLong()
        UwUObject.UwURef(region, this)
    }
    override val isStatic = false

    override fun free(obj: UwUObject) {
        val start = (obj as UwUObject.UwURef).address.area.first
        val size = UwUMem.data[start].toInt()
        for (i in start + 1 .. start + size) {
            val item = type.getObj(UwUMem.data, i)
            if (item is UwUObject.UwURef) item.address.refs--
        }
    }

    fun items(obj: UwUObject.UwURef): List<UwUObject> {
        val start = obj.address.area.first
        val size = UwUMem.data[start].toInt()
        val items = mutableListOf<UwUObject>()
        for (i in start + 1 .. start + size) {
            val item = type.getObj(UwUMem.data, i)
            items.add(item)
        }
        return items
    }

    fun setItems(obj: UwUObject.UwURef, items: List<UwUObject>) {
        val start = obj.address.area.first
        val size = UwUMem.data[start].toInt()
        for ((n, i) in (start + 1 .. start + size).withIndex()) {
            val item = type.getObj(UwUMem.data, i)
            if (item is UwUObject.UwURef) item.address.refs--
            items[n].type.putObj(UwUMem.data, i, items[n])
        }
    }
}
