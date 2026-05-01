package com.worstprogrammer.worstkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform