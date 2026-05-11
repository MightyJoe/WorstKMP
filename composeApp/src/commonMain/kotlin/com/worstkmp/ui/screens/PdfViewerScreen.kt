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
import com.worstkmp.domain.model.Calibration
import org.koin.compose.viewmodel.koinViewModel   // ← Koin magic

class PdfViewerScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: PdfViewerScreenModel = koinViewModel()

        val calibrations by viewModel.calibrations.collectAsState(initial = emptyList())

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("PDF Viewer Screen (the heart of the app)", style = MaterialTheme.typography.headlineMedium)

            // Placeholder for PDF — tap anywhere to add calibration point
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "📄 [PDF would render here]\n\nTap here to add calibration point\n(GPS / manual coords coming soon)",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Button(onClick = { viewModel.addCalibrationPoint("New point from tap") }) {
                Text("Tap to Add Calibration Point")
            }

            Text("Saved points on this PDF: ${calibrations.size}")

            Button(onClick = { navigator.pop() }) {
                Text("← Back to Home")
            }
        }
    }
}