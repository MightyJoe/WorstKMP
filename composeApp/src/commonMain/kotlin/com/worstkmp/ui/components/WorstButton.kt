package com.worstkmp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

/**
 * # WorstButton
 *
 * ### Clickable Action Component - Tap Target Acquired! 🐧
 *
 * Alright team, listen up! This is your go-to interactive button component for the
 * WorstKMP design system. When users need to trigger an action, this is your weapon
 * of choice. Click it, tap it, press it - this button's ready for deployment!
 *
 * #### Tactical Specifications
 * - **Action Trigger**: One tap, instant response - no hesitation!
 * - **Theme Integration**: Auto-syncs with WorstKMP colors and shapes - seamless integration
 * - **State Control**: Enabled/disabled modes - full operational control
 * - **Customization Protocol**: Shape, colors, elevation - configure to mission specs
 * - **Content Flexible**: Text, icons, whatever you need - we adapt!
 *
 * #### Mission Objectives
 * Perfect for form submissions, dialog confirmations, navigation triggers, or any
 * situation requiring user-initiated action. Handles touch interactions like a pro,
 * provides visual feedback, and integrates with the WorstKMP theme automatically.
 * Just the way we like it!
 *
 * > **STANDING ORDERS**
 * > DO NOT use `androidx.compose.material3.Button` directly.
 * > Always deploy `WorstButton`. We maintain standards here, soldier!
 * 
 * ---
 *
 * @param onClick Action to execute when a button is tapped - your mission callback
 * @param modifier Tactical adjustments for size, padding, and battlefield positioning
 * @param enabled Operational status - true for active, false for disabled state
 * @param shape Button contour configuration - rounded by default for smooth operations
 * @param colors Color scheme for container and content - theme-integrated
 * @param elevation Shadow depth for that tactical dimension - keeps it snappy
 * @param border Optional perimeter stroke - when you need that extra definition
 * @param contentPadding Interior spacing protocol - keeps content comfortable
 * @param interactionSource Touch event monitor - for advanced interaction tracking
 * @param content Your button's payload - text, icons, whatever the mission requires
 */
@Composable
fun WorstButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = com.worstkmp.ui.theme.getWorstShapes().medium,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = com.worstkmp.ui.theme.getWorstColorScheme().primary
    ),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable () -> Unit = {}
) {
    com.worstkmp.ui.theme.WorstTheme {
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
