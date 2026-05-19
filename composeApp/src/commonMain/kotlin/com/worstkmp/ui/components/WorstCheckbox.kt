package com.worstkmp.ui.components

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
                checkedColor = _root_ide_package_.com.worstkmp.ui.theme.getWorstColorScheme().primary,
                uncheckedColor = _root_ide_package_.com.worstkmp.ui.theme.getWorstColorScheme().primary,
                checkmarkColor = _root_ide_package_.com.worstkmp.ui.theme.getWorstColorScheme().onPrimary,
            )
        )

        if (label != null) {
            Spacer(modifier = Modifier.width(8.dp))
            WorstText(
                text = label,
                style = _root_ide_package_.com.worstkmp.ui.theme.getWorstTypography().bodyLarge,
                color = if (enabled) _root_ide_package_.com.worstkmp.ui.theme.getWorstColorScheme().onSurface
                else _root_ide_package_.com.worstkmp.ui.theme.getWorstColorScheme().onSurface.copy(alpha = 0.6f)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewWorstCheckbox() {
    _root_ide_package_.com.worstkmp.ui.theme.WorstTheme {
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
    _root_ide_package_.com.worstkmp.ui.theme.WorstTheme {
        WorstSurface() {
            WorstCheckbox(
                checked = true,
                onCheckedChange = null,
                label = "Check this out!"
            )
        }
    }
}
