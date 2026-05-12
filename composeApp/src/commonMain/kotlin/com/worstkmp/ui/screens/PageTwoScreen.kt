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
import com.worstkmp.presentation.viewmodel.HomeScreenViewModel
import com.worstkmp.presentation.viewmodel.PageTwoViewModel

class PageTwoScreen : Screen {

    @Composable
    override fun Content() {
        val navigator: cafe.adriel.voyager.navigator.Navigator = LocalNavigator.currentOrThrow
        val viewModel: PageTwoViewModel = rememberScreenModel { PageTwoViewModel() }   // Voyager keeps track of the viewModel (and lifecycle)


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

            Button(onClick = { navigator.push(PageThreeScreen()) }) {
                Text("Go to Page Three →")
            }

            Button(onClick = { navigator.pop() }) {
                Text("← Back to Home")
            }
        }
    }
}