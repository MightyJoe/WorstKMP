package com.worstkmp.presentation

import com.worstkmp.domain.model.Inspection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class InspectionViewModel {
    private val _inspection = MutableStateFlow<Inspection?>(null)
    val inspection: StateFlow<Inspection?> = _inspection.asStateFlow()

    fun loadDemoInspection() {
        _inspection.value = Inspection(
            id = 1,
            title = "The Wurst Inspection Ever",
            items = listOf(
                ChecklistItem(1, "Check for sausage leaks", false),
                ChecklistItem(2, "Verify bratwurst temperature", true)
            )
        )
    }

    fun toggleItem(itemId: Long) {
        _inspection.value = _inspection.value?.copy(
            items = _inspection.value?.items?.map { item ->
                if (item.id == itemId) item.copy(completed = !item.completed) else item
            } ?: emptyList()
        )
    }
}