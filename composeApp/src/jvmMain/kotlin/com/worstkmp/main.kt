package com.worstkmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.worstkmp.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "WorstKMP",
    ) {
        App()
    }
}