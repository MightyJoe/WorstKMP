package com.worstkmp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.worstkmp.data.local.AppStateRepository
import com.worstkmp.domain.enum.ScreenType
import com.worstkmp.domain.model.AppState
import com.worstkmp.presentation.viewmodel.HomeScreenViewModel
import com.worstkmp.presentation.viewmodel.PageTwoViewModel
import kotlinx.coroutines.launch
import org.koin.compose.getKoin
import kotlin.time.Clock

class PageTwoScreen : Screen {

    @Composable
    override fun Content() {
        val navigator: cafe.adriel.voyager.navigator.Navigator = LocalNavigator.currentOrThrow
        val viewModel: PageTwoViewModel = rememberScreenModel { PageTwoViewModel() }   // Voyager keeps track of the viewModel (and lifecycle)

        val koin = getKoin()
        val repository: AppStateRepository = koin.get()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Page Two", style = MaterialTheme.typography.headlineLarge)

            Text("This is the second screen.\nYou can navigate back.")

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = {
                kotlinx.coroutines.MainScope().launch {
                    repository.insert(
                        AppState(
                            lastScreen = ScreenType.PAGE_THREE.name,
                            lastScreenJSON = "",
                            backStackJSON = "",
                            lastUpdated = Clock.System.now().toEpochMilliseconds()
                        )
                    )
                }
                navigator.push(PageThreeScreen())
            }) {

                Text("Go to Page Three →")
            }

            Button(onClick = {
                val previousScreenName = if (navigator.items.size > 1) {
                    when (navigator.items[navigator.items.size - 2]) {
                        is HomeScreen -> ScreenType.HOME.name
                        is PageTwoScreen -> ScreenType.PAGE_TWO.name
                        is PageThreeScreen -> ScreenType.PAGE_THREE.name
                        else -> ScreenType.HOME.name
                    }
                } else {
                    ScreenType.HOME.name
                }

                kotlinx.coroutines.MainScope().launch {
                    repository.insert(
                        AppState(
                            lastScreen = previousScreenName,
                            lastScreenJSON = "",
                            backStackJSON = "",
                            lastUpdated = Clock.System.now().toEpochMilliseconds()
                        )
                    )
                }

                navigator.pop() }) {
                Text("← Back to Home")
            }
        }
    }
}