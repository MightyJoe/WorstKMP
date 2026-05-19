package com.worstkmp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel

/**
 * Holds all UI state for HomeScreen.
 * Data class pattern ensures immutable, testable state updates via copy().
 */
data class HomeUiState(
    val selectedTab: Int = 0,           // 0 = Home, 1 = Maps, 2 = Map Viewer, 3 = Settings
    val welcomeMessage: String = "Welcome to WorstKMP",
    val showTutorial: Boolean = true
    // Later we can add: recentPdfs, recentTracks, isLoading, etc.
)

/**
 * ViewModel for HomeScreen using a mutableStateOf delegation pattern.
 * Extends ScreenModel for Voyager integration.
 */
class HomeScreenViewModel : ScreenModel {

    /**
     * Observable UI state. Compose recomposes when this changes.
     * Private setter ensures only the ViewModel can modify the state.
     */
    var uiState by mutableStateOf(HomeUiState())
        private set

    /**
     * Updates selected tab index.
     * Ignores redundant selections to prevent unnecessary recompositions.
     */
    fun selectTab(newTab: Int) {
        if (newTab == uiState.selectedTab) return

        uiState = uiState.copy(selectedTab = newTab)

        // TODO: Trigger side effects here (analytics, loading data for that tab, etc.)
    }

    /**
     * Returns welcome message from the current state.
     */
    fun getWelcomeMessage(): String {
        return uiState.welcomeMessage
    }

    // Example of how we can evolve later:
    // fun dismissTutorial() {
    //     uiState = uiState.copy(showTutorial = false)
    // }
}