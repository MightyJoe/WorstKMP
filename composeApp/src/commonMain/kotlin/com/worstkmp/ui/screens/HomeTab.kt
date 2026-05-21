package com.worstkmp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.worstkmp.ui.components.WorstLazyColumn
import com.worstkmp.ui.components.WorstLoading
import com.worstkmp.ui.components.WorstSurface
import com.worstkmp.ui.components.WorstText
import com.worstkmp.ui.theme.WorstTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun HomeTab(modifier: Modifier = Modifier) {
    var isLoading by remember { mutableStateOf(true) }

    // Simulate loading delay
    LaunchedEffect(Unit) {
        delay(2000.milliseconds)
        isLoading = false
    }

    WorstSurface(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        if(isLoading) {
            WorstLoading(modifier = Modifier.wrapContentSize())
        }
        else {
            WorstLazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    WorstText(
                        text = "Welcome to your Home screen!",
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                item {
                    WorstText(text = "This content appeared after the fake loading delay.")
                }
            }
        }

    }

}

@Preview
@Composable
fun HomeTabPreview() {
    WorstTheme {
        HomeTab()
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeTabNightModePreview() {
    WorstTheme {
        HomeTab()
    }
}

