package com.worstkmp.ui.theme

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * WorstCheckbox - Official checkbox for the WorstKMP design system.
 *
 * Use this everywhere instead of raw androidx.compose.material3.Checkbox.
 */
@Composable
fun WorstCheckbox(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String? = null
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.material3.Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled,
            colors = CheckboxDefaults.colors(
                checkedColor = getWorstColorScheme().primary,
                uncheckedColor = getWorstColorScheme().primary,
                checkmarkColor = getWorstColorScheme().onPrimary,
            )
        )

        if (label != null) {
            Spacer(modifier = Modifier.width(8.dp))
            WorstText(
                text = label,
                style = getWorstTypography().bodyLarge,
                color = if (enabled) getWorstColorScheme().onSurface
                else getWorstColorScheme().onSurface.copy(alpha = 0.6f)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewWorstCheckbox() {
    WorstTheme {
        WorstCheckbox(
            checked = true,
            onCheckedChange = null,
            label = "Test Label"
        )
    }
}

@Preview( uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewWorstCheckboxDark() {
    WorstTheme {
        WorstSurface() {
            WorstCheckbox(
                checked = true,
                onCheckedChange = null,
                label = "Test Label"
            )
        }
    }
}
