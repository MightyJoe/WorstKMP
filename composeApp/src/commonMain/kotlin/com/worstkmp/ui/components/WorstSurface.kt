package com.worstkmp.ui.components

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
 * # WorstSurface
 *
 * ### Base Layer Deployment - Foundation Secured! 🐧
 *
 * This is your backmost element - the absolute foundation of every screen.
 * This is the root background that everything else sits on top of. Think of it as the 
 * ice beneath our flippers - solid, reliable, and always there when you need it!
 *
 * #### Strategic Position
 * - **Bottom Layer**: Nothing goes beneath this - it's the floor, soldier!
 * - **Full Coverage**: Fills the entire operation zone by default
 * - **Theme Synchronized**: Auto-adapts to light/dark mode - we're tactical like that
 * - **Zero Elevation**: Flat as the Antarctic ice sheet - no shadows, no questions
 *
 * #### Operational Notes
 * Every screen in this application deploys on top of a WorstSurface. It's the canvas,
 * the stage, the launching pad for all your UI operations. You want a consistent base?
 * This is it. You want proper color theming? Already handled. You want to look
 * professional? WorstSurface has got your six!
 *
 * > **STANDING ORDERS**
 * > DO NOT use `androidx.compose.material3.Surface` directly.
 * > Always deploy `WorstSurface`. We maintain surface standards here, people!
 *
 * ---
 */
@Composable
fun WorstSurface(
    modifier: Modifier = Modifier.fillMaxSize(),
    shape: androidx.compose.ui.graphics.Shape = androidx.compose.ui.graphics.RectangleShape,
    color: Color = _root_ide_package_.com.worstkmp.ui.theme.getWorstColorScheme().surface,
    contentColor: Color = _root_ide_package_.com.worstkmp.ui.theme.getWorstColorScheme().onSurface,
    tonalElevation: androidx.compose.ui.unit.Dp = 0.dp,
    shadowElevation: androidx.compose.ui.unit.Dp = 0.dp,
    border: androidx.compose.foundation.BorderStroke? = null,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable () -> Unit
) {
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


@Preview
@Composable
private fun WorstSurfacePreview() {
    WorstSurface() {
        WorstCard(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            WorstText(
                text = "I REJECT NATURE!",
                style = _root_ide_package_.com.worstkmp.ui.theme.getWorstTypography().headlineMedium
            )
            WorstButton(
                onClick = {}
            ) {
                WorstText(text = "Get that egg!")
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun WorstSurfaceDarkPreview() {
    _root_ide_package_.com.worstkmp.ui.theme.WorstTheme {
        WorstSurface {
            WorstCard (modifier = Modifier.fillMaxWidth().padding(16.dp)){
                WorstText(
                    text = "Seal Explosions",
                    style = _root_ide_package_.com.worstkmp.ui.theme.getWorstTypography().headlineMedium
                )
                WorstButton(
                    onClick = {}
                ) {
                    WorstText(text = "Woah.")
                }
            }
        }
    }
}
