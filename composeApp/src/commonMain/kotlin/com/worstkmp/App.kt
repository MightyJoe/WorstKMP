package com.worstkmp


import androidx.compose.runtime.Composable
import com.worstkmp.navigation.AppNavigation
import com.worstkmp.ui.theme.WorstTheme


@Composable
fun App() {
    WorstTheme {
        AppNavigation() // Voyager navigation runs the ui.
    }
}