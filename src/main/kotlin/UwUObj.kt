import UwUMem.currentFlag
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

    abstract fun refs(obj: UwUObject): List<UwUObject>

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
    var currentFlag = false

    // 8 KiB ought to be enough for anybody
    val data = LongArray(1024)

    val tree = MemoryBlock(data.indices)

    class MemoryBlock(val area: IntRange) {
        var left: MemoryBlock? = null
        var right: MemoryBlock? = null
        var available: Boolean = true
        val size get() = area.last + 1 - area.first
        var type: UwUType = UwUPrimitive.UwuVoid
        var gcFlag = currentFlag

        fun findInUse(): List<MemoryBlock> {
            return if (!available) {
                listOf(this)
            } else {
                (left?.findAllocated() ?: emptyList()) + (right?.findAllocated() ?: emptyList())
            }
        }

        fun removeEmpty(): Boolean {
            if (!available) return false
            if (left == null && right == null) return true
            val l = left?.removeEmpty() != false
            if (l) left = null
            val r = right?.removeEmpty() != false
            if (r) right = null
            if (l && r) {
                return true
            }
            return false
        }

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
            return "$type at $area"
        }

        fun findFree(sizeWords: Int, type: UwUType): MemoryBlock? {
            val bucketSize = (sizeWords shl 1).takeHighestOneBit()  // TODO: make this smorter
            val midpoint = (area.first + area.last + 1) / 2
            return when {
                !available -> null
                size == bucketSize && left == null && right == null -> this.apply { available = false; this.type = type;  }
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

//    private fun gcRound() {
//        val freeable = tree.findAllocated().filter { it.refs == 0 }.sortedBy { it.allocationTime }.run { take(size / 2) }
//        for (item in freeable) {
//            item.type.free(UwUObject.UwURef(item, item.type))
////            item.free()
//        }
//        tree.freeEmpty2()
//    }

    private fun mark(obj: MemoryBlock) {
        if (obj.gcFlag == currentFlag) return  // no loops
        obj.gcFlag = currentFlag
        val refs = obj.type.refs(obj.type.getObj(data, obj.area.first)).mapNotNull { (it as? UwUObject.UwURef)?.address }
        for (item in refs) {
            mark(item)
        }
    }

    private fun sweep() {
        var i = 0
        val objs = tree.findAllocated()
        for (allocated in objs) {
            if (!allocated.available && allocated.gcFlag != currentFlag) {
                i++
                allocated.free()
            }
        }
        println("Swept $i of ${objs.size} objects")
        tree.removeEmpty()
    }

    val rootObjects = mutableListOf<MemoryBlock>()

    fun gc() {
//        gcRound()
//        gcRound()
//        for (item in tree.findFreeable()) {
//            if (item.refs != 0) continue
//            item.type.free(UwUObject.UwURef(item, item.type))
//        }
//        tree.freeEmpty()
        currentFlag = !currentFlag
        rootObjects.forEach { mark(it) }
        sweep()
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

    data class UwURef(val address: UwUMem.MemoryBlock, override val type: UwUType) : UwUObject {
        fun keepalive() {
            address.gcFlag = currentFlag
        }
    }

    data class UwUStatic(var value: Long, override val type: UwUType) : UwUObject
}

sealed class UwUPrimitive(name: UwUName) : UwUType(name) {
    override val isStatic: Boolean = true
    override fun free(obj: UwUObject) {}

    override fun refs(obj: UwUObject): List<UwUObject> = emptyList()

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

    override fun free(obj: UwUObject) {}

    override fun refs(obj: UwUObject): List<UwUObject> = fields.map { field(obj as UwUObject.UwURef, it) }.filter { !it.type.isStatic }

    fun field(obj: UwUObject.UwURef, field: UwuField): UwUObject {
        return field.type.getObj(UwUMem.data, obj.address.area.first + field.offset)
    }

    fun setField(obj: UwUObject.UwURef, field: UwuField, value: UwUObject) {
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
            type.putObj(UwUMem.data, addr.toInt(), toPut)
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

    override fun free(obj: UwUObject) {}

    override fun refs(obj: UwUObject): List<UwUObject> = if (obj is UwUObject.UwUStatic) emptyList() else items(obj as UwUObject.UwURef).filter { !it.type.isStatic }

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
            items[n].type.putObj(UwUMem.data, i, items[n])
        }
    }
}
