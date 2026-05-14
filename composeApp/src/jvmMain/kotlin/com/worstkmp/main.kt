package com.worstkmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.worstkmp.di.appModule
import org.koin.core.context.startKoin

fun main() = application {
    // Start Koin for Desktop
    startKoin {
        modules(appModule)
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "WorstKMP"
    ) {
        App()
    }
}