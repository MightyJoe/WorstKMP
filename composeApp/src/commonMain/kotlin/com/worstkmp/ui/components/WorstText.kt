package com.worstkmp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import com.worstkmp.ui.theme.getWorstColorScheme
import com.worstkmp.ui.theme.getWorstTypography
import kotlin.String


/**
 * # WorstText
 *
 * ### Textual Communication Command Unit - Deploy Words with Precision! 🐧
 *
 * This is your go-to text rendering operative for all textual
 * communication needs. Whether you're displaying mission briefings, status updates,
 * or just saying "Smile and wave, boys!", WorstText has got your back!
 *
 * #### Operational Parameters
 * - **Typography Arsenal**: Full access to WorstTypography styles - locked and loaded
 * - **Color Schemes**: Adaptive theming support - blends in or stands out on command
 * - **Tactical Flexibility**: Supports clicks, overflow handling, text styling - the works!
 * - **Layout Control**: Alignment, wrapping, line limits - you name it, we control it
 *
 * > **STRATEGIC DIRECTIVE**
 * > DO NOT use `androidx.compose.material3.Text` directly in your codebase.
 * > Always deploy WorstText for consistent theming and behavior. That's the Skipper way!
 * 
 * ---
 *
 * @param text The actual message - what are we telling the troops?
 * @param modifier Tactical positioning and appearance adjustments
 * @param style Typography style from WorstTypography - choose your weapon wisely
 * @param color Text color override - sometimes you need that special ops touch
 * @param textAlign Text alignment strategy - left flank, center formation, or right wing
 * @param fontSize Font size override - when style alone isn't enough firepower
 * @param fontStyle Italic, normal - add that tactical emphasis
 * @param fontWeight Bold operations require bold text - you get the picture
 * @param fontFamily Custom font family - when you need to go undercover
 * @param letterSpacing Space between letters - spread 'em out or keep 'em tight
 * @param textDecoration Underline, strikethrough - mark that text for special attention
 * @param lineHeight Vertical spacing between lines - breathing room, people!
 * @param overflow What happens when text gets too chatty - clip, ellipsis, or visible
 * @param softWrap Line breaking strategy - wrap it or let it run wild
 * @param maxLines Maximum line deployment - keep it concise, soldier
 * @param minLines Minimum line requirement - maintain formation even when brief
 * @param onTextLayout Layout callback for advanced tactical maneuvers
 * @param onClick Optional click handler - make that text interactive!
 */
@Composable
fun WorstText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = com.worstkmp.ui.theme.getWorstTypography().bodyLarge,
    color: Color = getWorstColorScheme().onSurface,
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

@Preview(showBackground = true, name = "Light Mode")
@Composable
private fun WorstTextPreview() {
            WorstText(modifier = Modifier.fillMaxWidth().padding(32.dp),
                text = "This is it boys!")
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun WorstTextDarkPreview() {
    WorstText(modifier = Modifier.fillMaxWidth().padding(32.dp),
        text = "Smile and wave, boys!")
}

@Preview(showBackground = true, name = "Light Mode")
@Composable
private fun WorstBigTextPreview() {
    WorstText(
        modifier = Modifier.fillMaxWidth().padding(32.dp),
        text = "This is it boys!",
        style = getWorstTypography().titleLarge
    )
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun WorstBigTextDarkPreview() {
    WorstText(
        modifier = Modifier.fillMaxWidth().padding(32.dp),
        text = "Smile and wave, boys!",
        style = getWorstTypography().headlineLarge
    )
}