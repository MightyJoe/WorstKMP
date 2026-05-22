package com.worstkmp

actual fun getPlatform(): Platform = JVMPlatform()

class JVMPlatform : Platform {
    override val name: String = "Desktop (JVM)"
}

