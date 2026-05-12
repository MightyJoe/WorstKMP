package com.worstkmp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.worstkmp.presentation.viewmodel.HomeScreenViewModel
import com.worstkmp.ui.theme.WorstCard
import com.worstkmp.ui.theme.*

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator: cafe.adriel.voyager.navigator.Navigator = LocalNavigator.currentOrThrow
        val viewModel: HomeScreenViewModel = rememberScreenModel { HomeScreenViewModel() }   // Voyager keeps track of the viewModel (and lifecycle)

        HomeScreenUI(
            message = viewModel.getWelcomeMessage(),
            pageTwoButtonOnClick = {
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