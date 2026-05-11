package com.worstkmp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.worstkmp.ui.theme.WorstButton
import com.worstkmp.ui.theme.WorstCard
import com.worstkmp.ui.theme.WorstSurface
import com.worstkmp.ui.theme.WorstText
import com.worstkmp.ui.theme.WorstTheme

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        WorstSurface {
            val navigator = LocalNavigator.currentOrThrow

            WorstCard {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    WorstText(
                        text = "WorstKMP Prototype",
                    )

                    WorstText("Home Screen – State will persist here soon")

                    WorstButton(onClick = { navigator.push(CalibrationScreen()) }) {
                        Text("Go to Calibration Screen →")
                    }

                    WorstText(
                        text = "Prototype goals reminder:\n" +
                                "• Compose UI (Godot comparison coming)\n" +
                                "• SQLDelight state survives kill/re-open\n" +
                                "• Permissionsa, Bluetooth, Camera, etc. next",
                    )


                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun HomeScreenPreview() {
        WorstTheme {
            Navigator(screen = HomeScreen())
        }
    }

    @Preview(showBackground = true, uiMode = 0x20)
    @Composable
    private fun HomeScreenDarkPreview() {
        WorstTheme(darkTheme = true) {
            Navigator(screen = HomeScreen())
        }
    }

}


