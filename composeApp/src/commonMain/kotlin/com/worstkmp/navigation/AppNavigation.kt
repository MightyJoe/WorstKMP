package com.worstkmp.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.worstkmp.ui.screens.CalibrationScreen
import com.worstkmp.ui.screens.HomeScreen

@Composable
fun AppNavigation() {
    // Voyager root — starts with our first real screen
    Navigator(screen = HomeScreen())
}