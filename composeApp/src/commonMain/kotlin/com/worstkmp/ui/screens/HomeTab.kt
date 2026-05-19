package com.worstkmp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.worstkmp.ui.components.WorstText

@Composable
fun HomeTab(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        WorstText("Home Tab")
    }
}