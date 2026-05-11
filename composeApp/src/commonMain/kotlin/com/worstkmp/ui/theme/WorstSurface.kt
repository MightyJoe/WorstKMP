package com.worstkmp.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * The backmost element of every screen.
 * This is the root background that everything else sits on top of.
 */
@Composable
fun WorstSurface(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        content = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = contentAlignment,
                propagateMinConstraints = propagateMinConstraints,
                content = content
            )
        }
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

