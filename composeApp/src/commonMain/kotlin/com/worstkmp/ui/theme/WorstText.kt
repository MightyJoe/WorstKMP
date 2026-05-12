package com.worstkmp.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import kotlin.String

@Composable
fun WorstText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    color: Color = Color.Unspecified,
    textAlign: TextAlign = TextAlign.Start,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
    onTextLayout: ((TextLayoutResult) -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    val finalStyle = if (color != Color.Unspecified) {
        style.copy(color = color)
    } else {
        style
    }

    val clickableModifier = if (onClick != null) {
        Modifier.clickable { onClick() }
    } else {
        Modifier
    }

    Text(
        text = text,
        modifier = modifier.then(clickableModifier),
        style = finalStyle,
        textAlign = textAlign,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        onTextLayout = onTextLayout,
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
                    onClick = {}
                ) {
                    WorstText(text = "Click Me")
                }
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
                    style = MaterialTheme.typography.headlineMedium
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