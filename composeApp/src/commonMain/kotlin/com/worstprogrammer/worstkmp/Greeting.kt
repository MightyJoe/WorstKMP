package com.worstprogrammer.worstkmp

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Go , ${platform.name}!"
    }
}