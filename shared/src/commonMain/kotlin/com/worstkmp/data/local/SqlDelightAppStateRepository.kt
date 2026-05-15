package com.worstkmp.data.local

import app.cash.sqldelight.coroutines.asFlow
import com.worstkmp.WorstDatabase
import com.worstkmp.domain.model.AppState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SqlDelightAppStateRepository(
    private val database: WorstDatabase
) : AppStateRepository {

    private val queries = database.worstDatabaseQueries

    override fun getAppState(): Flow<AppState> {
        return queries.selectAppState()
            .asFlow()
            .map { result ->
                val row = result.executeAsOneOrNull()
                row?.let {
                    AppState(
                        lastScreen = it.last_screen,
                        lastScreenJSON = it.last_screen_data,
                        backStackJSON = it.back_stack,
                        lastUpdated = it.last_updated
                    )
                } ?: AppState()   // default if no row yet
            }
    }

    override suspend fun insert(appState: AppState) {
        queries.insertAppState(
            id = 1L,
            last_screen = appState.lastScreen,
            last_screen_data = appState.lastScreenJSON,
            back_stack = appState.backStackJSON,
            last_updated = appState.lastUpdated
        )
    }

}