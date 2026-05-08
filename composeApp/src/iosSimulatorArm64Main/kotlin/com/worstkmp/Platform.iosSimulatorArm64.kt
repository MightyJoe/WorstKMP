package com.worstkmp

import platform.UIKit.UIDevice

actual fun getPlatform(): Platform = IOSPlatform()

class IOSPlatform : Platform {
    override val name: String
        get() = "${UIDevice.currentDevice.systemName()} ${UIDevice.currentDevice.systemVersion}"
}