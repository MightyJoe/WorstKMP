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
 * # WorstCheckbox
 *
 * ### Binary Selection Device - Checkbox Deployment Protocol! 🐧
 *
 * This is your standard-issue checkbox component for the
 * WorstKMP design system. When you need users to make a yes/no decision, confirm an option,
 * or toggle a setting, this is your tactical widget of choice. Clean checkmarks, optional labels,
 * and ready for any boolean operation you throw at it!
 *
 * #### Tactical Specifications
 * - **Boolean Control**: Check or uncheck - simple, effective, no nonsense!
 * - **Theme Integration**: Auto-syncs with WorstKMP colors - smooth operation
 * - **Label Support**: Optional text label for clarity - communication is key!
 * - **Enabled State**: Full enable/disable capability - lock it down when needed
 * - **Event Handling**: Callback integration for state changes - stay informed!
 *
 * #### Mission Objectives
 * Deploy this checkbox for confirmations, multi-select lists, settings toggles,
 * or any situation requiring binary user input. It's got theming, it's got labels,
 * and it plays nice with the rest of the squad. Everything a penguin commander could want!
 *
 * > **STANDING ORDERS**
 * > DO NOT use `androidx.compose.material3.Checkbox` directly.
 * > Always deploy `WorstCheckbox`. We maintain checkbox standards here, people!
 *
 * ---
 *
 * @param checked Current check state - is the box ticked or not, soldier?
 * @param onCheckedChange Callback for state changes - reports back to command
 * @param modifier Tactical adjustments for size and battlefield positioning
 * @param enabled Enable/disable the checkbox - sometimes we need to lock things down
 * @param label Optional text label - tell 'em what they're checking!
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
            label = "Cheesy Dibbles"
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
                label = "Diversion!"
            )
        }
    }
}
