package com.worstkmp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.worstkmp.data.local.AppStateRepository
import com.worstkmp.domain.enum.ScreenType
import com.worstkmp.domain.model.AppState
import com.worstkmp.presentation.viewmodel.HomeScreenViewModel
import com.worstkmp.ui.theme.*
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import org.koin.compose.getKoin

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val koin = getKoin()
        val repository: AppStateRepository = koin.get()
        val viewModel = rememberScreenModel { HomeScreenViewModel() }

        // This is the Compose + MVVM binding pattern.
        val state = viewModel.uiState

        // Restore last screen on first load
        LaunchedEffect(Unit) {
            val savedState: AppState? = repository.getAppState().firstOrNull()
            if (savedState != null) {
                val target = when (savedState.lastScreen) {
                    ScreenType.PAGE_TWO.name -> PageTwoScreen()
                    ScreenType.PAGE_THREE.name -> PageThreeScreen()
                    else -> null
                }
                target?.let { navigator.push(it) }
            }
        }

        HomeScreenUI(
            message = state.welcomeMessage,
            onGoToPageTwo = {
                // Save current screen before navigating
                kotlinx.coroutines.MainScope().launch {
                    repository.insert(
                        AppState(lastScreen = ScreenType.PAGE_TWO.name)
                    )
                }
                navigator.push(PageTwoScreen())
            },
            selectedTab = state.selectedTab,
            onTabSelected = viewModel::selectTab ,
        )
    }

    @Composable
    fun HomeScreenUI(
        message: String = "Welcome to WorstKMP",
        onGoToPageTwo: () -> Unit = {},
        selectedTab: Int = 0,                    // NEW
        onTabSelected: (Int) -> Unit = {}        // NEW
    ) {
        WorstSurface(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {

                // Existing content
                WorstCard(modifier = Modifier.padding(16.dp)) {
                    WorstText(text = message)
                }
                WorstCard(modifier = Modifier.padding(16.dp)) {
                    WorstButton(onClick = onGoToPageTwo) {
                        WorstText(text = "Go to Page Two")
                    }
                }

                // TEMP debug (we'll remove later)
                WorstText(text = "Selected Tab: $selectedTab")

                Spacer(modifier = Modifier.weight(1f))

                // NEW: Simple bottom navigation
                NavigationBar {
                    NavigationBarItem(
                        selected = selectedTab == 0,
                        onClick = { onTabSelected(0) },
                        icon = { /* TODO: Add icon later */ },
                        label = { WorstText(text = "Home") }
                    )
                    NavigationBarItem(
                        selected = selectedTab == 1,
                        onClick = { onTabSelected(1) },
                        icon = { /* TODO: Add icon later */ },
                        label = { WorstText(text = "PDFs") }
                    )
                    NavigationBarItem(
                        selected = selectedTab == 2,
                        onClick = { onTabSelected(2) },
                        icon = { /* TODO: Add icon later */ },
                        label = { WorstText(text = "Map") }
                    )
                    NavigationBarItem(
                        selected = selectedTab == 3,
                        onClick = { onTabSelected(3) },
                        icon = { /* TODO: Add icon later */ },
                        label = { WorstText(text = "Settings") }
                    )
                }
            }
        }
    }

    @Preview
    @Composable
    fun Preview() {
        HomeScreenUI()
    }

    @Preview(uiMode = UI_MODE_NIGHT_YES)
    @Composable
    fun NightModePreview() {
        HomeScreenUI()
    }
}