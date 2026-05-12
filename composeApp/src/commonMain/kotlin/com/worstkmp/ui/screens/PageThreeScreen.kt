package com.worstkmp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

class PageThreeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Page Three", style = MaterialTheme.typography.headlineLarge)

            Text("You are deep in the navigation stack now.")

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = { navigator.pop() }) {
                Text("← Back")
            }

            Button(onClick = { navigator.popUntil { it is HomeScreen } }) {
                Text("Back to Home (pop all)")
            }
        }
    }
}