package com.worstkmp.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.worstkmp.ui.theme.getWorstColorScheme

/**
 * # WorstNavigationBar
 *
 * ### Tactical Navigation Command Center - Bottom Position, Maximum Impact 🐧
 *
 * Listen up, people! This is your mission-critical horizontal navigation component,
 * strategically anchored at the screen's southern perimeter. Deploys 3-5 navigation
 * items for rapid-fire switching between top-level destinations. No dilly-dallying!
 *
 * #### Operational Parameters
 * - **Strategic Positioning**: Bottom screen placement for optimal thumb accessibility
 * - **Force Deployment**: Houses 3-5 WorstNavigationBarItems
 * - **Mission Flexibility**: Theming adapts fast!
 * - **Elevation Tactics**: Tonal elevation for that subtle depth - we keep it classy
 *
 * > **NO EXCEPTIONS**
 * > DO NOT use `androidx.compose.material3.NavigationBar` directly.
 * > Always use `WorstNavigationBar`. That's an order, not a suggestion!
 * 
 * ---
 *
 * @param modifier Tactical layout adjustments and appearance modifications
 * @param containerColor Background color - your navigation bar's dress uniform
 * @param contentColor Text/icon color for items - keep it readable, soldier
 * @param tonalElevation Depth illusion via elevation - adds that tactical edge
 * @param content Your WorstNavigationBarItems go here - lock and load
 *
 * @see WorstNavigationBarItem
 */
@Composable
fun WorstNavigationBar(
    modifier: Modifier = Modifier,
    containerColor: Color = getWorstColorScheme().surface,
    contentColor: Color = getWorstColorScheme().onSurface,
    tonalElevation: Dp = NavigationBarDefaults.Elevation,
    content: @Composable RowScope.() -> Unit
) {
    NavigationBar(
        modifier = modifier,
        containerColor = containerColor,
        contentColor = contentColor,
        tonalElevation = tonalElevation,
        content = content
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
