package com.worstkmp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.worstkmp.ui.theme.WorstCard
import com.worstkmp.ui.theme.*

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        HomeScreenUI()

    }

    @Composable
    fun HomeScreenUI() {
        WorstSurface(modifier = Modifier.fillMaxSize()) {
            WorstCard(modifier = Modifier.padding(16.dp)) {
                WorstText(
                    text = "WorstKMP Prototype",
                )
                WorstButton(onClick = {}) {
                    WorstText(text = "Start")
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