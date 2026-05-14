package com.worstkmp.data.local

import com.worstkmp.domain.model.AppState
import kotlinx.coroutines.flow.Flow

interface AppStateRepository {
    fun getAppState(): Flow<AppState>
    suspend fun insert(appState: AppState)
}