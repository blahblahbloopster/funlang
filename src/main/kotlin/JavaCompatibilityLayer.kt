import UwUMem.nil
import UwUPrimitive.UwUDouble.double
import UwUPrimitive.UwUDouble.long
import stdlib.UwUString
import java.lang.ref.Cleaner
import java.lang.reflect.Constructor
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import kotlin.random.Random.Default.nextLong

class JavaType(clazz: Class<*>) : UwUType(UwUName("javacompat", *clazz.name.split('.').toTypedArray())) {
    companion object {
        private val registry = mutableMapOf<Class<*>, JavaType>()

        operator fun get(cls: Class<*>?): UwUType {
            return when (cls) {
                null -> UwUPrimitive.UwuVoid

                Byte::class.java -> UwUPrimitive.UwULong
                Short::class.java -> UwUPrimitive.UwULong
                Int::class.java -> UwUPrimitive.UwULong
                Long::class.java -> UwUPrimitive.UwULong

                Float::class.java -> UwUPrimitive.UwUDouble
                Double::class.java -> UwUPrimitive.UwUDouble

                Boolean::class.java -> UwUPrimitive.UwUBoolean

                String::class.java -> UwUString

                Char::class.java -> UwUPrimitive.UwUChar

                java.lang.Object::class.java -> UwUAny

                else -> registry.getOrPut(cls) { JavaType(cls) }
            }
        }

        fun unpack(obj: UwUObject): Any? {
            return when (obj) {
                is UwUObject.UwUStatic -> when (obj.type) {
                    UwUPrimitive.UwULong -> obj.value.toInt()
                    UwUPrimitive.UwUDouble -> obj.value.double()
                    UwUPrimitive.UwUBoolean -> obj.value != 0L
                    UwUPrimitive.UwUChar -> obj.value.toInt().toChar()
                    UwUPrimitive.UwuVoid -> null
                    else -> throw NotImplementedError("wat $obj")
                }
                is UwUObject.UwURef -> throw NotImplementedError()
                is JavaObject -> obj.obj
            }
        }

        fun pack(obj: Any?): UwUObject {
            return when (obj) {
                null -> nil

                is Byte -> UwUObject.UwUStatic(obj.toLong(), UwUPrimitive.UwULong)
                is Short -> UwUObject.UwUStatic(obj.toLong(), UwUPrimitive.UwULong)
                is Int -> UwUObject.UwUStatic(obj.toLong(), UwUPrimitive.UwULong)
                is Long -> UwUObject.UwUStatic(obj, UwUPrimitive.UwULong)

                is Float -> UwUObject.UwUStatic(obj.toDouble().long(), UwUPrimitive.UwUDouble)
                is Double -> UwUObject.UwUStatic(obj.long(), UwUPrimitive.UwUDouble)

                is Boolean -> UwUObject.UwUStatic(if (obj) 1L else 0L, UwUPrimitive.UwUBoolean)

                is String -> TODO()

                else -> JavaObject(obj, JavaType[obj.javaClass] as JavaType)
            }
        }
    }

    class JavaObjectField(private val field: Field) : UwUField {
        override val name: String = field.name
        override val type: UwUType by lazy { JavaType[field.type] }

        override fun retrieve(obj: UwUObject): UwUObject {
            val o = unpack(obj)
            return pack(field.get(o))
        }

        override fun set(obj: UwUObject, value: UwUObject) {
            val o = unpack(obj)
            val v = unpack(value)
            field.set(o, v)
        }
    }

    class JavaObjectMethod(private val method: Method) : UwUMethod {
        override val arguments: List<Pair<String, UwUType>> by lazy { method.parameters.map { it.name to JavaType[it.type] } }
        override val name: String = method.name
        override val static: Boolean = Modifier.isStatic(method.modifiers)

        override fun invoke(obj: UwUObject, args: List<UwUObject>): UwUObject {
            val o = unpack(obj)
            val res = method.invoke(o, *(args.map { unpack(it) }.toTypedArray()))
            return pack(res)
        }
    }

    class JavaConstructor(private val constructor: Constructor<*>) : UwUConstructor {
        override val arguments: List<Pair<String, UwUType>> by lazy { constructor.parameters.map { it.name to JavaType[it.type] } }

        override fun invoke(args: List<UwUObject>): UwUObject {
            return pack(constructor.newInstance(*args.map { unpack(it) }.toTypedArray()))
        }
    }

    override val methods: List<UwUMethod> = clazz.methods.map { JavaObjectMethod(it) }
    override val constructors: List<UwUConstructor> = clazz.constructors.map { JavaConstructor(it) }
    override val isStatic: Boolean = false
    override val fields: List<UwUField> = clazz.fields.map { JavaObjectField(it) }
    override val nullConstructor: UwUConstructor = UwUConstructor.NativeConstructor(emptyList()) { UwUObject.UwUStatic(-1L, this) }

    override fun refs(obj: UwUObject): List<UwUObject> {
        return emptyList()  // handled by the java GC
    }

    override fun free(obj: UwUObject) {
        TODO()
    }
}

class JavaObject(val obj: Any?, override val type: JavaType) : UwUObject, Cleaner.Cleanable {
    internal companion object {
        val objects = hashMapOf<Long, Pair<Long, Any?>>()
        val inverse = hashMapOf<Any?, Long>()

        private val cleaner = Cleaner.create()
    }

    private val id = inverse.getOrPut(obj) { nextLong() }

    init {
        val existing = objects[id]
        if (existing != null) {
            objects[id] = existing.first + 1 to existing.second
        } else {
            objects[id] = 1L to obj
        }
        cleaner.register(this) {}
    }

    override fun clean() {
        println("cleaning object")
        val entry = objects[id]!!
        objects[id] = entry.first - 1 to entry.second
        if (entry.first - 1 <= 0L) {
            objects.remove(id)
        }
    }
}
