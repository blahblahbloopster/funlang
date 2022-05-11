import UwUMem.data
import UwUMem.malloc
import UwUMem.nil
import kotlin.random.Random.Default.nextLong

sealed class UwUType(val name: UwUName) {
    abstract val methods: List<UwUMethod>
    abstract val constructors: List<UwUConstructor>
    abstract val isStatic: Boolean
    abstract val fields: List<UwUField>
    abstract val nullConstructor: UwUConstructor

    fun findMethod(name: String, args: List<UwUType>): UwUMethod {
        return methods.find { it.name == name && it.arguments.mapIndexed { index, pair -> pair.second == args.getOrNull(index) || pair.second === UwUAny }.all { v -> v } } ?: throw RuntimeException("Method '$name' with arguments $args not found for type ${this.name}!")
    }

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

    override fun equals(other: Any?): Boolean {
        return if (other === UwUAny || this === UwUAny) true else this === other
//        if (this === other) return true
//        if (javaClass != other?.javaClass) return false
//
//        other as UwUType
//
//        if (name != other.name) return false
//
//        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object {
        val registry = mutableMapOf<UwUName, UwUType>()
        val idRegistry = mutableMapOf<Long, UwUType>()
    }

    val id = nextLong()

    init {
        registry[name] = this
        idRegistry[id] = this
    }

    fun field(obj: UwUObject, name: String): UwUObject {
        val field = fields.find { it.name == name } ?: throw RuntimeException("Field '$name' not found on object of type ${this.name}!")
        return field.retrieve(obj)
    }

    fun fieldOrNull(obj: UwUObject, name: String): UwUObject? {
        val field = fields.find { it.name == name } ?: return null
        return field.retrieve(obj)
    }

    fun field(obj: UwUObject, name: String, value: UwUObject) {
        val field = fields.find { it.name == name } ?: throw RuntimeException("Field '$name' not found on object of type ${this.name}!")
        field.set(obj, value)
    }

    fun constructor(args: List<UwUObject>): UwUObject {
        val cons = constructors.find { it.arguments.size == args.size && it.arguments.mapIndexed { index, pair -> pair.second == args[index].type }.all { v -> v } } ?: throw RuntimeException("Constructor not found!")  // TODO: arg types in error
        return cons.invoke(args)
    }
}

interface UwUField {
    val name: String
    val type: UwUType

    fun retrieve(obj: UwUObject): UwUObject

    fun set(obj: UwUObject, value: UwUObject)
}

class UwUStructField(override val name: String, override val type: UwUType, val offset: Int) : UwUField {
    override fun retrieve(obj: UwUObject): UwUObject {
        val pointer = (obj as UwUObject.UwURef).address.area.first + offset
        return type.getObj(data, pointer)
    }

    override fun set(obj: UwUObject, value: UwUObject) {
        type.putObj(data, (obj as UwUObject.UwURef).address.area.first + offset, value)
    }
}

interface UwUMethod {
    val name: String
    val arguments: List<Pair<String, UwUType>>
    val static: Boolean

    fun invoke(obj: UwUObject, args: List<UwUObject>): UwUObject

    class NativeMethod(override val name: String,
                       override val arguments: List<Pair<String, UwUType>>,
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
                data.fill(-1L, obj.area.first, obj.area.last + 1)
                return UwUObject.UwURef(obj, type)
            } else if (type is JavaType) {
                val obj = JavaObject(null, type)
                return obj
            }
            throw NotImplementedError("No default constructor for ${type.name}!")
        }
    }
}

object UwUMem {
    var currentFlag = false

    // 8 MiB ought to be enough for anybody
    val data = LongArray(512)

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
            var bucketSize = (sizeWords shl 1).takeHighestOneBit()
            if (bucketSize shr 1 == sizeWords) bucketSize = sizeWords
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
        currentFlag = !currentFlag
        rootObjects.forEach { mark(it) }
        sweep()
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

    data class UwURef(
        val address: UwUMem.MemoryBlock,
        override val type: UwUType,
    ) : UwUObject

    data class UwUStatic(var value: Long, override val type: UwUType) : UwUObject
}

sealed class UwUPrimitive(name: UwUName) : UwUType(name) {
    override val isStatic: Boolean = true
    override val fields: List<UwUField> = emptyList()
    override val nullConstructor = UwUConstructor.NativeConstructor(emptyList()) { UwUObject.UwUStatic(-1L, this) }

    override fun free(obj: UwUObject) {}

    override fun refs(obj: UwUObject): List<UwUObject> = emptyList()

    object UwuVoid : UwUPrimitive(UwUName("uwu", "Void")) {
        override val methods: List<UwUMethod> = emptyList()
        override val constructors: List<UwUConstructor> = listOf(nullConstructor)
    }
    object UwULong : UwUPrimitive(UwUName("uwu", "Wong")) {
        override val constructors: List<UwUConstructor> = listOf(nullConstructor)
        override val methods = listOf(
            UwUMethod.NativeMethod("pwus", listOf("b" to UwULong)) { a, b -> UwUObject.UwUStatic((a as UwUObject.UwUStatic).value + (b[0] as UwUObject.UwUStatic).value, UwULong) },
            UwUMethod.NativeMethod("minus", listOf("b" to UwULong)) { a, b -> UwUObject.UwUStatic((a as UwUObject.UwUStatic).value - (b[0] as UwUObject.UwUStatic).value, UwULong) },
            UwUMethod.NativeMethod("times", listOf("b" to UwULong)) { a, b -> UwUObject.UwUStatic((a as UwUObject.UwUStatic).value * (b[0] as UwUObject.UwUStatic).value, UwULong) },
            UwUMethod.NativeMethod("divide", listOf("b" to UwULong)) { a, b -> UwUObject.UwUStatic((a as UwUObject.UwUStatic).value / (b[0] as UwUObject.UwUStatic).value, UwULong) },
            UwUMethod.NativeMethod("eqwaws", listOf("b" to UwULong)) { a, b -> UwUObject.UwUStatic(if ((a as UwUObject.UwUStatic).value == (b[0] as UwUObject.UwUStatic).value) 1L else 0L, UwUBoolean) },
            UwUMethod.NativeMethod("wessthan", listOf("b" to UwULong)) { a, b -> UwUObject.UwUStatic(if ((a as UwUObject.UwUStatic).value < (b[0] as UwUObject.UwUStatic).value) 1L else 0L, UwUBoolean) },
        )
    }
    object UwUDouble : UwUPrimitive(UwUName("uwu", "Doubwe")) {
        override val constructors: List<UwUConstructor> = listOf(nullConstructor)
        fun Long.double() = java.lang.Double.longBitsToDouble(this)
        fun Double.long() = java.lang.Double.doubleToLongBits(this)

        override val methods = listOf(
            UwUMethod.NativeMethod("plus", listOf("b" to UwUDouble)) { a, b -> UwUObject.UwUStatic(((a as UwUObject.UwUStatic).value.double() + (b[0] as UwUObject.UwUStatic).value.double()).long(), UwUDouble) },
            UwUMethod.NativeMethod("minus", listOf("b" to UwUDouble)) { a, b -> UwUObject.UwUStatic(((a as UwUObject.UwUStatic).value.double() - (b[0] as UwUObject.UwUStatic).value.double()).long(), UwUDouble) },
            UwUMethod.NativeMethod("times", listOf("b" to UwUDouble)) { a, b -> UwUObject.UwUStatic(((a as UwUObject.UwUStatic).value.double() * (b[0] as UwUObject.UwUStatic).value.double()).long(), UwUDouble) },
            UwUMethod.NativeMethod("divide", listOf("b" to UwUDouble)) { a, b -> UwUObject.UwUStatic(((a as UwUObject.UwUStatic).value.double() / (b[0] as UwUObject.UwUStatic).value.double()).long(), UwUDouble) },
        )
    }

    object UwUChar : UwUPrimitive(UwUName("uwu", "Chaw")) {
        override val constructors: List<UwUConstructor> = listOf(nullConstructor)
        override val methods: List<UwUMethod> = emptyList()
    }

    object UwUBoolean : UwUPrimitive(UwUName("uwu", "Boowean")) {
        override val constructors: List<UwUConstructor> = listOf(nullConstructor)
        override val methods: List<UwUMethod> = emptyList()
    }
}

class UwUName(vararg val names: String) {
    val simpleName = names.last()

    override fun toString(): String {
        return names.joinToString(".")
    }

    override fun equals(other: Any?): Boolean {
        if (other !is UwUName) return false
        return other.names.contentEquals(names)
    }

    override fun hashCode(): Int {
        return names.contentHashCode()
    }
}

open class UwUStruct(
    name: UwUName,
    override val fields: MutableList<UwUStructField>,
    override val methods: MutableList<UwUMethod>,
    override val constructors: MutableList<UwUConstructor>,
) : UwUType(name) {
    override val isStatic: Boolean = false
    val sizeWords get() = (fields.maxOfOrNull { it.offset } ?: -1) + 1
    override val nullConstructor: UwUConstructor = UwUConstructor.NullConstructor(this)

    override fun free(obj: UwUObject) {}

    override fun refs(obj: UwUObject): List<UwUObject> = fields.mapNotNull { field(obj as? UwUObject.UwURef ?: return@mapNotNull null, it.name) }.filter { !it.type.isStatic }
}

object UwUAny : UwUType(UwUName("uwu", "Any")) {
    override val methods: List<UwUMethod> = emptyList()
    override val constructors: List<UwUConstructor> get() = TODO("Not yet implemented")
    override val isStatic: Boolean get() = TODO("Not yet implemented")
    override val fields: List<UwUField> get() = TODO("Not yet implemented")
    override val nullConstructor: UwUConstructor get() = TODO()

    override fun refs(obj: UwUObject): List<UwUObject> {
        TODO("Not yet implemented")
    }

    override fun free(obj: UwUObject) {
        TODO("Not yet implemented")
    }
}

object UwUArray : UwUType(UwUName("uwu", "Awway")) {
    override val methods = listOf(
        UwUMethod.NativeMethod("get", listOf("index" to UwUPrimitive.UwULong)) { a, b ->
            val index = (b[0] as UwUObject.UwUStatic).value
            val addr = (a as UwUObject.UwURef).address.area.first + index + 2
            val type = idRegistry[data[a.address.area.first + 1]]!!
            type.getObj(data, addr.toInt())
        },
        UwUMethod.NativeMethod("set", listOf("index" to UwUPrimitive.UwULong, "obj" to UwUAny)) { a, b ->
            val index = (b[0] as UwUObject.UwUStatic).value
            val toPut = b[1]
            val addr = (a as UwUObject.UwURef).address.area.first + index + 2
            putObj(data, addr.toInt(), toPut)
            nil
        },
        UwUMethod.NativeMethod("getSize", emptyList()) { a, b ->
            UwUPrimitive.UwULong.getObj(data, (a as UwUObject.UwURef).address.area.first)
        },
        UwUMethod.NativeMethod("getType", emptyList()) { a, _ ->
            idRegistry[data[(a as UwUObject.UwURef).address.area.first + 1]]!!.run { UwUConstructor.NullConstructor(this).invoke(emptyList()) }
        }
    )
    override val fields: List<UwUField> = emptyList()
    override val constructors: List<UwUConstructor> = listOf(UwUConstructor.NativeConstructor(listOf("type" to UwUAny,"size" to UwUPrimitive.UwULong)) { args ->
        val size = (args[1] as UwUObject.UwUStatic).value.toInt()
        val region = malloc(size + 2, this)
        data[region.area.first] = size.toLong()
        data[region.area.first + 1] = args[0].type.id
        UwUObject.UwURef(region, this)
    })
    override val nullConstructor: UwUConstructor get() = TODO()
    override val isStatic = false

    override fun free(obj: UwUObject) {}

    override fun refs(obj: UwUObject): List<UwUObject> = if (obj is UwUObject.UwUStatic) emptyList() else items(obj as UwUObject.UwURef).filter { !it.type.isStatic }

    fun items(obj: UwUObject.UwURef): List<UwUObject> {
        val start = obj.address.area.first
        val size = data[start].toInt()
        val type = data[start + 1]
        val items = mutableListOf<UwUObject>()
        for (i in start + 2 .. start + size + 1) {
            val item = idRegistry[type]!!.getObj(UwUMem.data, i)
            items.add(item)
        }
        return items
    }

    fun setItems(obj: UwUObject.UwURef, items: List<UwUObject>) {
        val start = obj.address.area.first
        val size = data[start].toInt()
        for ((n, i) in (start + 2 .. start + size + 1).withIndex()) {
            items[n].type.putObj(data, i, items[n])
        }
    }
}
