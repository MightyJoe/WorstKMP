package com.worstkmp.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.model.ScreenModel

/**
 * The single source of truth for HomeScreen UI state.
 * Using a data class + copy() makes state changes predictable and easy to test.
 */
data class HomeUiState(
    val selectedTab: Int = 0,           // 0 = Home, 1 = Load PDFs, 2 = PDF Viewer, 3 = Compass, 4 = AR, 5 = Settings
    val welcomeMessage: String = "Welcome to WorstKMP",
    val showTutorial: Boolean = true
    // Later we can add: recentPdfs, recentTracks, isLoading, etc.
)

/**
 * HomeScreenViewModel now owns all UI state for the Home area using
 * mutableStateOf + delegation. This is the pattern we will use across the app.
 *
 * It extends ScreenModel so it works with Voyager's rememberScreenModel.
 */
class HomeScreenViewModel : ScreenModel {

    /**
     * The observable UI state. Screens read this with "by".
     * Only this ViewModel can write to it (thanks to private set).
     */
    var uiState by mutableStateOf(HomeUiState())
        private set

    /**
     * Called when the user taps a bottom navigation item.
     * This keeps "which screen we are on" centralized and solid.
     */
    fun selectTab(newTab: Int) {
        if (newTab == uiState.selectedTab) return

        uiState = uiState.copy(selectedTab = newTab)

        // Future: we can trigger side effects here (analytics, loading data for that tab, etc.)
    }

    /**
     * Keeps existing behavior for now.
     * Later we can move the message fully into uiState if we want.
     */
    fun getWelcomeMessage(): String {
        return uiState.welcomeMessage
    }

    // Example of how we can evolve later:
    // fun dismissTutorial() {
    //     uiState = uiState.copy(showTutorial = false)
    // }
}