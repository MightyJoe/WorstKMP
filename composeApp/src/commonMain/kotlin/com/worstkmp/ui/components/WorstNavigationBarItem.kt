package com.worstkmp.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.worstkmp.ui.theme.getWorstColorScheme

/**
 * # WorstNavigationBarItem
 *
 * ### Individual Navigation - Ready for Deployment! 🐧
 *
 * This is your precision-engineered navigation destination component,
 * designed to slot seamlessly into WorstNavigationBar formation. Each item is a highly trained
 * tactical unit, equipped with icon, optional label, and lightning-fast state transitions.
 * No questions, just results!
 *
 * #### Combat-Ready Features
 * - **State Awareness**: Auto-detects selected/unselected states - no manual intervention required!
 * - **Color Camouflage**: Automatically pulls WorstKMP theme colors - blends right in, boys!
 * - **Access Protocols**: Enabled/disabled states for when the mission gets complicated
 * - **Visual Signals**: Indicator backgrounds and color shifts - user always knows their position
 * - **Label Options**: Show 'em always, never, or just when selected - your call, Private!
 *
 * #### The Mission Brief
 * This component delivers immediate visual feedback through tactical color orchestration
 * and smooth indicator animations. Users get crisp, responsive navigation that feels
 * snappy and professional. Just smile and wave, boys. Smile and wave.
 *
 * > **OPERATION DIRECTIVE**
 * > DO NOT use `androidx.compose.material3.NavigationBarItem` directly.
 * > Always deploy `WorstNavigationBarItem`. We don't break formation here!
 * 
 * ---
 *
 * @param selected Is this our current destination? Boolean intel required
 * @param onClick Action sequence when a user taps this bad boy
 * @param icon Visual identifier for this navigation point - keep it recognizable!
 * @param modifier Field modifications for layout and tactical positioning
 * @param enabled Can users interact with this? Default is affirmative
 * @param label Optional text intel displayed under the icon
 * @param alwaysShowLabel Keep that label visible at all times? (default: affirmative)
 * @param selectedIconColor Icon color when we're locked on target
 * @param unselectedIconColor Icon color when we're in standby mode
 * @param selectedTextColor Text color when this destination is active
 * @param unselectedTextColor Text color when standing by
 * @param indicatorColor Background highlight for the selected state
 *
 * @see WorstNavigationBar
 */
@Composable
fun RowScope.WorstNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
    selectedIconColor: Color = getWorstColorScheme().primary,
    unselectedIconColor: Color = getWorstColorScheme().onSurfaceVariant,
    selectedTextColor: Color = getWorstColorScheme().primary,
    unselectedTextColor: Color = getWorstColorScheme().onSurfaceVariant,
    indicatorColor: Color = getWorstColorScheme().primary.copy(alpha = 0.1f)
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = selectedIconColor,
            unselectedIconColor = unselectedIconColor,
            selectedTextColor = selectedTextColor,
            unselectedTextColor = unselectedTextColor,
            indicatorColor = indicatorColor
        )
    )
}
//
//@Preview(showBackground = true, name = "Light Mode")
//@Composable
//private fun WorstNavigationBarItemLightPreview() {
//    var selectedItem by remember { mutableStateOf(0) }
//
//    NavigationBarPreview(selectedItem)
//}
//
//@Preview(uiMode = UI_MODE_NIGHT_YES, name = "Dark Mode")
//@Composable
//private fun WorstNavigationBarItemDarkPreview() {
//    var selectedItem by remember { mutableStateOf(1) }
//
//    NavigationBarPreview(selectedItem)
//}
//
//@Composable
//public fun NavigationBarPreview(selectedItem: Int) {
//    var selectedItem1 = selectedItem
//    Surface {
//        WorstNavigationBar {
//            WorstNavigationBarItem(
//                selected = selectedItem1 == 0,
//                onClick = { selectedItem1 = 0 },
//                icon = { Icon(Icons.Filled.Home, contentDescription = "Home Base") },
//                label = { Text("HQ") }
//            )
//            WorstNavigationBarItem(
//                selected = selectedItem1 == 1,
//                onClick = { selectedItem1 = 1 },
//                icon = { Icon(Icons.Filled.Search, contentDescription = "Recon Mission") },
//                label = { Text("Search") }
//            )
//            WorstNavigationBarItem(
//                selected = selectedItem1 == 2,
//                onClick = { selectedItem1 = 2 },
//                icon = { Icon(Icons.Filled.Settings, contentDescription = "Command Center") },
//                label = { Text("Settings") }
//            )
//        }
//    }
//}
//
