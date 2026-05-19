package com.worstkmp.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.worstkmp.ui.screens.HomeScreen

/**
 * The root of the app's navigation graph.
 * This wraps the whole app in a [Navigator] for use with Voyager navigation.
 */
@Composable
fun AppNavigation() {
    Navigator(screen = HomeScreen())
}