package com.worstkmp.data.local

import app.cash.sqldelight.coroutines.asFlow
import com.worstkmp.WorstDatabase
import com.worstkmp.domain.model.AppState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SqlDelightAppStateRepository(
    database: WorstDatabase
) : AppStateRepository {

    private val queries = database.worstDatabaseQueries

    override fun getAppState(): Flow<AppState> {
        return queries.selectAppState()
            .asFlow()
            .map { result ->
                val row = result.executeAsOneOrNull()
                if (row == null) {
                    AppState() // return default when nothing is saved yet
                } else {
                    AppState(
                        lastScreen = row.last_screen,
                        lastScreenJSON = row.last_screen_data,
                        backStackJSON = row.back_stack,
                        lastUpdated = row.last_updated
                    )
                }
            }
    }

    override suspend fun insert(appState: AppState) {
        queries.insertAppState(
            last_screen = appState.lastScreen,
            last_screen_data = appState.lastScreenJSON,
            back_stack = appState.backStackJSON,
            last_updated = appState.lastUpdated
        )
    }

}