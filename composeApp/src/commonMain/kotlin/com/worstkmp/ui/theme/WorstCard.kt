package com.worstkmp.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WorstCard(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outline) // Very subtle dark mode border

    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = contentAlignment,
            content = content
        )
    }
}

@Preview
@Composable
private fun WorstSurfacePreview() {
    WorstTheme {
        WorstSurface {
            WorstCard {
                WorstText(
                    text = "WorstSurface Preview",
                    style = MaterialTheme.typography.headlineMedium
                )
                WorstButton(
                    text = "Click Me",
                    onClick = {}
                )
            }
        }
    }
}

@Preview
@Composable
private fun WorstSurfaceDarkPreview() {
    WorstTheme(darkTheme = true) {
        WorstSurface {
            WorstCard {
                WorstText(
                    text = "WorstSurface Preview",
                    style = MaterialTheme.typography.headlineMedium
                )
                WorstButton(
                    text = "Click Me",
                    onClick = {}
                )
            }
        }
    }
}