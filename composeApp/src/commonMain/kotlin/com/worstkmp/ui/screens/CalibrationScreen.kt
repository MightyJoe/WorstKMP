package com.worstkmp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.worstkmp.ui.theme.WorstSurface

class CalibrationScreen : Screen {

    @Composable
    override fun Content() {

        WorstSurface {
            val navigator = LocalNavigator.currentOrThrow

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Calibration Screen",
                    style = MaterialTheme.typography.headlineMedium
                )

                Text("This is where SQLDelight persistence will live (next step)")

                Button(onClick = { navigator.pop() }) {
                    Text("← Back to Home")
                }

                // Future button for adding data (safe for now)
                Button(onClick = { /* TODO: connect to repository next */ }) {
                    Text("Add Calibration (persists across kills)")
                }
            }
        }
    }
}