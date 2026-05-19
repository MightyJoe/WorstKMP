package com.worstkmp.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.worstkmp.ui.theme.WorstTheme

@Composable
fun WorstLoading(
    modifier: Modifier = Modifier,
    size: Dp = 48.dp,
    color: Color = WorstTheme.colors.primary,
    trackColor : Color = WorstTheme.colors.secondary,
    strokeWidth: Dp = rememberInfiniteTransition(label = "strokeWidthAnimation").animateValue(
        initialValue = 1.dp,
        targetValue = 2.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "strokeWidth"
    ).value,
    useRotation: Boolean = true
) {


    if (useRotation) {
        CircularProgressIndicator(
            modifier = modifier
                .size(size)
                .drawWithContent {
                    drawContent()
                },
            color = color,
            trackColor = trackColor,
            strokeWidth = strokeWidth
        )
    } else {
        CircularProgressIndicator(
            modifier = modifier.size(size)
                .drawWithContent {
                    drawContent()

                },
            trackColor = trackColor,
            color = color,
            strokeWidth = strokeWidth
        )
    }
}

@Preview
@Composable
fun WorstLoadingPreview() {
    WorstLoading(modifier = Modifier.padding(16.dp))

}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun WorstLoadingNightModePreview() {
    WorstLoading(modifier = Modifier.padding(16.dp))

}

