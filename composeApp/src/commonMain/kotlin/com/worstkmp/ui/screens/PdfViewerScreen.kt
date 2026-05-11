package com.worstkmp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.worstkmp.presentation.viewmodel.PdfViewerScreenViewModel
import com.worstkmp.ui.theme.WorstButton
import com.worstkmp.ui.theme.WorstSurface
import com.worstkmp.ui.theme.WorstText
import com.worstkmp.ui.theme.WorstTheme

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
                WorstText("PDF Viewer (Core Inspection Screen)", style = MaterialTheme.typography.headlineMedium)

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    WorstText(
                        "📄 [PDF / Map would render here]\n\nTap anywhere to add calibration point",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                WorstButton(onClick = { viewModel.addCalibrationPoint(null) }) {
                    WorstText("Add Calibration Point")
                }

                WorstText("Saved points on this PDF: ${calibrations.size}")

                WorstButton(onClick = { navigator.pop() }) {
                    WorstText("← Back to Home")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun PdfViewerScreenPreview() {
        WorstTheme {
            Navigator(screen = PdfViewerScreen())
        }
    }

    @Preview(showBackground = true, uiMode = 0x20)
    @Composable
    private fun PdfViewerScreenDarkPreview() {
        WorstTheme(darkTheme = true) {
            Navigator(screen = PdfViewerScreen())
        }
    }
}

