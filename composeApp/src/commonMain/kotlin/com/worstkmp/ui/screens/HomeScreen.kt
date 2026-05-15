package com.worstkmp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.worstkmp.data.local.AppStateRepository
import com.worstkmp.domain.model.AppState
import com.worstkmp.presentation.viewmodel.HomeScreenViewModel
import com.worstkmp.ui.theme.WorstCard
import com.worstkmp.ui.theme.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.compose.getKoin
import kotlin.time.Clock

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator: Navigator = LocalNavigator.currentOrThrow
        val viewModel: HomeScreenViewModel = rememberScreenModel { HomeScreenViewModel() }   // Voyager keeps track of the viewModel (and lifecycle)

        val koin = getKoin()
        val repository: AppStateRepository = koin.get()
        val appState by repository.getAppState().collectAsState(
            initial = null
        ) 

        // Restore last screen if it's not HOME
        LaunchedEffect(appState?.lastScreen) {
            when (appState?.lastScreen) {
                "PAGETWO"   -> navigator.replace(PageTwoScreen())
                "PAGETHREE" -> navigator.replace(PageThreeScreen())
                // "HOME" does nothing — we stay here
            }
        }

        HomeScreenUI(
            message = viewModel.getWelcomeMessage(),
            pageTwoButtonOnClick = {
                MainScope().launch {
                    repository.insert(
                        AppState(
                            lastScreen = "PAGETWO",
                            lastScreenJSON = "",
                            backStackJSON = "",
                            lastUpdated = Clock.System.now().toEpochMilliseconds()
                        )
                    )
                }
                navigator.push(PageTwoScreen())
            }
        )
    }

    @Composable
    fun HomeScreenUI(
        message: String = "Welcome to WorstKMP",
        pageTwoButtonOnClick: () -> Unit = {}, // Default to empty function
    ) {
        WorstSurface(modifier = Modifier.fillMaxSize()) {
            Column {
                WorstCard(modifier = Modifier.padding(16.dp)) {
                    WorstText(
                        text = message,
                    )
                }
                WorstCard(modifier = Modifier.padding(16.dp)) {
                    WorstButton(onClick = {
                        println("=== BUTTON CLICKED ===")
                        pageTwoButtonOnClick.invoke()
                    }) {
                        WorstText(text = "Go to Page Two")
                    }
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