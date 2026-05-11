package com.worstkmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Calibration(
    val id: Long = 0,
    val pdfFileName: String = "",           // e.g. "site_map.pdf"
    val point1: MapPoint = MapPoint(),              // Known coordinate 1
    val point2: MapPoint = MapPoint(),
    val point3: MapPoint = MapPoint(),
    val lastUpdated: Long = 0L
)

@Serializable
data class MapPoint(
    val pdfX: Float = 0f,     // Position on the PDF image
    val pdfY: Float = 0f,
    val realLat: Double = 0.0, // Real-world GPS coordinate
    val realLon: Double = 0.0
)