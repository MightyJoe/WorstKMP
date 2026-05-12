package com.worstkmp.ui.theme

/**
 * DO NOT USE androidx.compose.material3.Surface directly.
 * Always use WorstSurface instead.
 */

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * The backmost element of every screen.
 * This is the root background that everything else sits on top of.
 */
@Composable
fun WorstSurface(
    modifier: Modifier = Modifier.fillMaxSize(),
    shape: androidx.compose.ui.graphics.Shape = androidx.compose.ui.graphics.RectangleShape,
    color: Color = getWorstColorScheme().surface,
    contentColor: Color = getWorstColorScheme().onSurface,
    tonalElevation: androidx.compose.ui.unit.Dp = 0.dp,
    shadowElevation: androidx.compose.ui.unit.Dp = 0.dp,
    border: androidx.compose.foundation.BorderStroke? = null,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable () -> Unit
) {
    WorstTheme {
        Surface(
            modifier = modifier,
            shape = shape,
            color = color,
            contentColor = contentColor,
            tonalElevation = tonalElevation,
            shadowElevation = shadowElevation,
            border = border,
            content = {
                androidx.compose.foundation.layout.Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = contentAlignment,
                    propagateMinConstraints = propagateMinConstraints
                ) {
                    content()
                }
            }
        )
    }
}


@Preview
@Composable
private fun WorstSurfacePreview() {
    WorstSurface() {
        WorstCard() {
            WorstText(
                text = "WorstSurface Preview",
                style = getWorstTypography().headlineMedium
            )
            WorstButton(
                onClick = {}
            ) {
                WorstText(text = "Click Me")
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun WorstSurfaceDarkPreview() {
    WorstTheme {
        WorstSurface {
            WorstCard {
                WorstText(
                    text = "WorstSurface Preview",
                    style = getWorstTypography().headlineMedium
                )
                WorstButton(
                    onClick = {}
                ) {
                    WorstText(text = "Click Me")
                }
            }
        }
    }
}
