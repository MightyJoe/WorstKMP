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

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                text = "WorstKMP Prototype",
                style = MaterialTheme.typography.headlineLarge
            )

            Text("Home Screen – State will persist here soon")

            Button(onClick = { navigator.push(CalibrationScreen()) }) {
                Text("Go to Calibration Screen →")
            }

            Text(
                text = "Prototype goals reminder:\n" +
                        "• Compose UI (Godot comparison coming)\n" +
                        "• SQLDelight state survives kill/re-open\n" +
                        "• Permissions, Bluetooth, Camera, etc. next",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}