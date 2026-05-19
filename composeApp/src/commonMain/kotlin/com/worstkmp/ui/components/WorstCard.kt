package com.worstkmp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * WorstCard - Official card for the WorstKMP design system.
 */
@Composable
fun WorstCard(
    modifier: Modifier = Modifier.wrapContentSize(),
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        shape = _root_ide_package_.com.worstkmp.ui.theme.getWorstShapes().large,
        colors = CardDefaults.cardColors(
            containerColor = _root_ide_package_.com.worstkmp.ui.theme.getWorstColorScheme().surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        border = BorderStroke(0.5.dp, _root_ide_package_.com.worstkmp.ui.theme.getWorstColorScheme().outline) // Very subtle dark mode border

    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = horizontalAlignment,
            content = content
        )
    }
}

@Preview
@Composable
private fun WorstSurfacePreview() {
    WorstSurface {
        WorstCard {
            WorstText(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            )
            WorstButton(
                onClick = {}
            ) {
                WorstText(text = "Lorem ipsum")
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun WorstSurfaceDarkPreview() {
    WorstSurface {
        WorstCard() {
            WorstText(
                text = "Darkem Ipsum",
            )
            WorstButton(
                onClick = {}
            ) {
                WorstText(text = "BRATWURST!")
            }
        }
    }
}