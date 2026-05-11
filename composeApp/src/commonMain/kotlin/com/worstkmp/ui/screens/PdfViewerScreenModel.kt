package com.worstkmp.ui.screens

import androidx.lifecycle.ViewModel
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.worstkmp.data.local.CalibrationRepository
import com.worstkmp.domain.model.Calibration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

class PdfViewerScreenModel(
    private val repository: CalibrationRepository   // ← injected by Koin
    , viewModelScope: CoroutineScope
) : ScreenModel{

    val calibrations: StateFlow<List<Calibration>> = repository.getAllCalibrations()

    fun addCalibrationPoint(name: String) {
        screenModelScope.launch {
            repository.insert(Calibration(pdfFileName = name))  // real DB write
        }
    }
}