package com.worstkmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Calibration(
    val id: Long = 0,
    val pdfFileName: String,           // e.g. "site_map.pdf"
    val point1: MapPoint,              // Known coordinate 1
    val point2: MapPoint,
    val point3: MapPoint,
    val lastUpdated: Long
)

@Serializable
data class MapPoint(
    val pdfX: Float,     // Position on the PDF image
    val pdfY: Float,
    val realLat: Double, // Real-world GPS coordinate
    val realLon: Double
)