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
import com.worstkmp.presentation.viewmodel.HomeScreenViewModel
import com.worstkmp.ui.theme.*
import org.koin.compose.getKoin

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val koin = getKoin()
        val repository: AppStateRepository = koin.get()
        val viewModel = rememberScreenModel { HomeScreenViewModel() }


        val state = viewModel.uiState // This is the Compose + MVVM binding pattern.

        HomeScreenUI(
            selectedTab = state.selectedTab,
            onTabSelected = viewModel::selectTab,
        )
    }

    @Composable
    fun HomeScreenUI(
        selectedTab: Int = 0,                    // NEW
        onTabSelected: (Int) -> Unit = {}        // NEW
    ) {
        WorstSurface(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {

                Spacer(modifier = Modifier.height(16.dp)) // Space so we are not on top of the nav bar.

                when (selectedTab) {
                    0 -> {
                        HomeTab(modifier = Modifier.weight(1f))
                    }
                    1 -> {
                        MapsTab(modifier = Modifier.weight(1f))
                    }
                    2 -> {
                        MapTab(modifier = Modifier.weight(1f))
                    }
                    3 -> {
                        SettingsTab(modifier = Modifier.weight(1f))
                    }
                    else -> {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }

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
                        label = { WorstText(text = "Maps") }
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
                        enabled = true,
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
        WorstTheme {
            HomeScreenUI()
        }
    }

    @Preview(uiMode = UI_MODE_NIGHT_YES)
    @Composable
    fun NightModePreview() {
        WorstTheme {
        HomeScreenUI()
        }
    }
}