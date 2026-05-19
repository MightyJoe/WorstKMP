package com.worstkmp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * WorstButton - Official button for the WorstKMP design system.
 */
@Composable
fun WorstButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = _root_ide_package_.com.worstkmp.ui.theme.getWorstShapes().medium,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = _root_ide_package_.com.worstkmp.ui.theme.getWorstColorScheme().primary
    ),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable () -> Unit = {}
) {
    _root_ide_package_.com.worstkmp.ui.theme.WorstTheme {
        Button(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            shape = shape,
            colors = colors,
            elevation = elevation,
            border = border,
            contentPadding = contentPadding,
            interactionSource = interactionSource,
            content = { content() }
        )
    }
}

@Preview
@Composable
private fun WorstSurfacePreview() {
    WorstButton(
        onClick = {}
    ) {
        WorstText("Click Me")
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun WorstSurfaceDarkPreview() {
    WorstButton(
        onClick = {}
    ) {
        WorstText("Click Me")
    }
}