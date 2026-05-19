package com.worstkmp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import com.worstkmp.ui.theme.getWorstColorScheme

/**
 * # WorstLazyColumn
 *
 * ### Vertical Scrolling Operations - Maximum Efficiency Mode! 🐧
 *
 * Alright team, listen up! This is your high-performance vertical list renderer,
 * optimized for smooth scrolling operations with lazy loading protocols. Only renders
 * what's visible on screen - we don't waste resources on what the user can't see!
 * Smart, efficient, and ready for heavy-duty content deployment.
 *
 * #### Tactical Specifications
 * - **Lazy Loading**: Items materialize only when needed - pure efficiency, people!
 * - **Scroll Control**: Full state management for programmatic navigation
 * - **Padding Protocols**: Configurable content padding for that perfect spacing
 * - **Vertical Formation**: Arrangement options - top, bottom, center, or space between!
 * - **Theme Integration**: Auto-pulls surface colors from WorstKMP - seamless camouflage!
 *
 * #### Mission Objectives
 * Perfect for deploying long lists, feeds, or any vertically stacked content that needs
 * to scroll smoothly without bogging down the system. Recycles views like a pro,
 * handles thousands of items without breaking a sweat. Just the way we like it!
 *
 * > **STANDING ORDERS**
 * > DO NOT use `androidx.compose.foundation.lazy.LazyColumn` directly.
 * > Always deploy `WorstLazyColumn`. We maintain standards here, soldier!
 * 
 * ---
 *
 * @param modifier Tactical adjustments for size, padding, and battlefield positioning
 * @param state Scroll position controller - for when you need manual override
 * @param contentPadding Interior spacing protocol - keeps content from the edges
 * @param verticalArrangement How items line up in formation - top, center, spaced, you name it
 * @param backgroundColor Surface color for the list container - blends with the theme
 * @param content Your list items go here - load 'em up and ship 'em out!
 */

@Composable
fun WorstLazyColumn(
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    backgroundColor: Color = getWorstColorScheme().surface,
    content: LazyListScope.() -> Unit
) {
    LazyColumn(
        modifier = modifier,
        state = state,
        contentPadding = contentPadding,
        verticalArrangement = verticalArrangement,
        content = content
    )
}

@Preview(showBackground = true, name = "Light Mode")
@Composable
private fun WorstLazyColumnLightPreview() {
    // Kowalski, analysis! Light mode operational preview - smooth scrolling confirmed!
    WorstLazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                WorstText("List Item #${index + 1} - Just smile and wave, boys!")
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
private fun WorstLazyColumnDarkPreview() {
    // Excellent work, boys! Dark mode preview - stealth operations at maximum efficiency!
    WorstLazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10) { index ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                WorstText("List Item #${index + 1} - Tactical midnight deployment!")
            }
        }
    }
}

