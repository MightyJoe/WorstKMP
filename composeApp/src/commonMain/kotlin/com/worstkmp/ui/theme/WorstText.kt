package com.worstkmp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WorstText(
    text: String,
    modifier: Modifier = Modifier,
    style: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.bodyLarge,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        style = style,
        modifier = modifier,
        textAlign = textAlign
    )
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