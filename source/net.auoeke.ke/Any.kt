@file:Suppress("NOTHING_TO_INLINE", "PLATFORM_CLASS_MAPPED_TO_KOTLIN", "unused")

package net.auoeke.ke

inline val Any.string: String get() = this.toString()
inline val Any?.string: String @JvmName("nullableString") get() = this.toString()
inline val Array<*>.string: String get() = this.contentToString()
inline val Any.classes: List<Class<*>> get() = this.type.hierarchy

inline fun Any.notify() = (this as Object).notify()
inline fun Any.notifyAll() = (this as Object).notifyAll()
inline fun Any.wait() = (this as Object).wait()
inline fun Any.wait(timeoutMillis: Long) = (this as Object).wait(timeoutMillis)
inline fun Any.wait(timeoutMillis: Long, nanos: Int) = (this as Object).wait(timeoutMillis, nanos)

inline val <reified T : Any> T.type: Class<T> get() = this.javaClass

inline fun <reified T> Any?.cast() = this as T
inline fun <reified T> Any?.isArray(): Boolean = type<Array<T>>().isInstance(this)
