package com.worstkmp.data.local

import com.worstkmp.domain.model.Calibration
import kotlinx.coroutines.flow.Flow

// Repository = Single source of truth for Calibration data
interface CalibrationRepository {

    // Get all calibrations (for "recent PDFs" list)
    fun getAllCalibrations(): Flow<List<Calibration>>

    // Get the most recently used one (great for "resume last session")
    fun getLatestCalibration(): Flow<Calibration?>

    // Get a specific calibration by ID
    fun getCalibrationByID(id: Long): Flow<Calibration?>

    // Save or update a calibration
    suspend fun saveCalibration(calibration: Calibration): Long   // returns the id

    // Delete
    suspend fun deleteCalibration(id: Long)
}