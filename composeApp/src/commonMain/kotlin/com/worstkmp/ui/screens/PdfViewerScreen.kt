package com.worstkmp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.worstkmp.presentation.viewmodel.PdfViewerScreenViewModel
import com.worstkmp.ui.theme.WorstSurface

class PdfViewerScreen : Screen {

    @Composable
    override fun Content() {
        WorstSurface {
            val navigator = LocalNavigator.currentOrThrow
            val viewModel = rememberScreenModel { PdfViewerScreenViewModel() }   // ← simple Voyager helper

            val calibrations by viewModel.calibrations.collectAsState(initial = emptyList())

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("PDF Viewer (Core Inspection Screen)", style = MaterialTheme.typography.headlineMedium)

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "📄 [PDF / Map would render here]\n\nTap anywhere to add calibration point",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Button(onClick = { viewModel.addCalibrationPoint(null) }) {
                    Text("Add Calibration Point")
                }

                Text("Saved points on this PDF: ${calibrations.size}")

                Button(onClick = { navigator.pop() }) {
                    Text("← Back to Home")
                }
            }
        }
    }
}