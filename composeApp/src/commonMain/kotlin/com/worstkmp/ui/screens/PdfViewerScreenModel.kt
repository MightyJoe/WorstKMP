package com.worstkmp.ui.screens

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.worstkmp.data.local.CalibrationRepository
import com.worstkmp.domain.model.Calibration
import com.worstkmp.domain.model.MapPoint
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PdfViewerScreenModel : ScreenModel, KoinComponent {

    private val repository: CalibrationRepository by inject()   // ← Koin injects the real repo

    // Convert SQLDelight Flow → StateFlow (Voyager-friendly)
    val calibrations: StateFlow<List<Calibration>> = repository.getAllCalibrations()
        .stateIn(
            scope = screenModelScope,
            started = SharingStarted.WhileSubscribed(5000), // keeps flow alive while screen is visible
            initialValue = emptyList()
        )

    fun addCalibrationPoint(calibrationPoint: MapPoint? = null) {
        screenModelScope.launch {
            repository.insert(Calibration()) //TODO add point to calibration later
        }
    }
}