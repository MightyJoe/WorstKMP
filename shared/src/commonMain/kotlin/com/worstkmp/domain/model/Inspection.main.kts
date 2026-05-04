package com.worstkmp.domain.model

data class Inspection(
    val id: Long,
    val title: String,
    val status: InspectionStatus = InspectionStatus.IN_PROGRESS,
    val items: List<ChecklistItem> = emptyList(),
    val photos: List<Photo> = emptyList()
)

enum class InspectionStatus {
    IN_PROGRESS, COMPLETED, FAILED
}

data class ChecklistItem(
    val id: Long,
    val question: String,
    var completed: Boolean = false,
    var notes: String = ""
)

data class Photo(
    val id: Long,
    val checklistItemId: Long?,
    val filePath: String,
    val timestamp: Long = System.currentTimeMillis()
)