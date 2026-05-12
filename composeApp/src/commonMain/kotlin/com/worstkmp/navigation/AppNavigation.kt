package com.worstkmp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.navigator.Navigator
import com.worstkmp.data.local.AppStateRepository
import com.worstkmp.ui.screens.HomeScreen
import com.worstkmp.ui.screens.PageThreeScreen
import com.worstkmp.ui.screens.PageTwoScreen
import org.koin.compose.getKoin

@Composable
fun AppNavigation() {
    val repository: AppStateRepository = getKoin().get()
    val appState by repository.getAppState().collectAsState(initial = null)

    Navigator(screen = HomeScreen()) { navigator ->
        LaunchedEffect(appState) {
            // Only navigate when we actually have data from the database
            if (appState != null) {
                val targetScreen = when (appState!!.lastScreen) {
                    "HOME" -> {
                        if (navigator.lastItem !is HomeScreen) {
                            HomeScreen()
                        } else {
                            return@LaunchedEffect
                        }
                    }
                    "PAGE_TWO" -> PageTwoScreen()
                    "PAGE_THREE" -> PageThreeScreen()
                    else -> throw Exception("Unknown screen: ${appState!!.lastScreen}")
                }
                targetScreen?.let { navigator.replace(it) }
            }
        }
    }
}
