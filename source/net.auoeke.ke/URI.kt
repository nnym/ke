@file:Suppress("unused")

package net.auoeke.ke

import java.io.*
import java.net.*
import java.nio.file.*
import kotlin.io.path.*

inline val URI.exists: Boolean get() = this.toPath().exists
inline val URI.asPath: Path get() = this.filesystem.provider().getPath(this)
inline val URI.asFile: File get() = this.asPath.asFile
inline val URI.asURL: URL get() = this.toURL()
inline val URI.newFilesystem: FileSystem get() = FileSystems.newFileSystem(this, mapOf<String, Any>())

// @formatter:off
val URI.filesystem: FileSystem get() = when (this.scheme) {
    "file" -> FileSystems.getDefault()
    else -> try {
        FileSystems.getFileSystem(this)
    } catch (_: FileSystemNotFoundException) {
        this.newFilesystem
    }
}
// @formatter:on
