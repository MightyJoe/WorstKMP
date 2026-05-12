package com.worstkmp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.worstkmp.presentation.viewmodel.PageThreeViewModel
import com.worstkmp.presentation.viewmodel.PageTwoViewModel
import com.worstkmp.ui.theme.WorstButton
import com.worstkmp.ui.theme.WorstText

class PageThreeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator: cafe.adriel.voyager.navigator.Navigator = LocalNavigator.currentOrThrow
        val viewModel: PageThreeViewModel = rememberScreenModel { PageThreeViewModel() }   // Voyager keeps track of the viewModel (and lifecycle)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WorstText("Page Three", style = MaterialTheme.typography.headlineLarge)

            Text("You are deep in the navigation stack now.")

            Spacer(modifier = Modifier.height(32.dp))

            WorstButton(onClick = { navigator.pop() }) {
                Text("← Back")
            }

            WorstButton(onClick = { navigator.popUntil { it is HomeScreen } }) {
                Text("Back to Home (pop all)")
            }
        }
    }
}