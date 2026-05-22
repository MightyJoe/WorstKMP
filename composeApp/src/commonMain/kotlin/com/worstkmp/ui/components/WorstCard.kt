package com.worstkmp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * # WorstCard
 *
 * ### Rectangular Containment Unit - Card Delivery System! 🐧
 *
 * This is your standard-issue card component for the
 * WorstKMP design system. When you need to group related content in a neat, professional
 * package, this is your tactical container of choice. Clean borders, subtle elevation,
 * and ready for any content you throw at it!
 *
 * #### Tactical Specifications
 * - **Content Containment**: Keeps your UI elements organized - no stragglers!
 * - **Theme Integration**: Auto-syncs with WorstKMP colors and shapes - smooth operation
 * - **Border Protocol**: Subtle outline for dark mode visibility - we see everything!
 * - **Zero Elevation**: Flat profile, maximum stealth - no unnecessary shadows
 * - **Flexible Layout**: Column-based content with custom alignment - adaptable to any mission
 *
 * #### Mission Objectives
 * Deploy this card for grouping related information, creating list items, building
 * profile sections, or any situation requiring content to be visually separated from
 * the background. It's got padding, it's got borders, and it plays nice with the theme.
 * Everything a penguin commander could want!
 *
 * > **STANDING ORDERS**
 * > DO NOT use `androidx.compose.material3.Card` directly.
 * > Always deploy `WorstCard`. We maintain card standards here, people!
 * 
 * ---
 *
 * @param modifier Tactical adjustments for size and battlefield positioning
 * @param horizontalAlignment Content horizontal alignment protocol - left flank by default
 * @param contentAlignment Overall content positioning - top-start formation (DEPRECATED - use horizontalAlignment)
 * @param content Your card's payload - text, buttons, whatever the mission requires
 */
@Composable
fun WorstCard(
    modifier: Modifier = Modifier.wrapContentSize(),
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        shape = com.worstkmp.ui.theme.getWorstShapes().large,
        colors = CardDefaults.cardColors(
            containerColor = com.worstkmp.ui.theme.getWorstColorScheme().surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        border = BorderStroke(0.5.dp, com.worstkmp.ui.theme.getWorstColorScheme().outline) // Very subtle dark mode border

    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = horizontalAlignment,
            content = content
        )
    }
}
//
//@Preview(name = "Light Mode", showBackground = false)
//@Composable
//private fun WorstSurfacePreview() {
//
//    WorstCard(
//        modifier = Modifier.fillMaxWidth().padding(16.dp)
//    ) {
//        WorstText(
//            text = "🐧 Card Component Preview",
//            style = MaterialTheme.typography.titleMedium,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//        WorstText(
//            text = "This is a beautiful WorstCard with some sample content to showcase its styling and layout capabilities.",
//            modifier = Modifier.padding(bottom = 12.dp)
//        )
//        WorstButton(
//            onClick = {},
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            WorstText(text = "Take Action!")
//        }
//    }
//}
//
//@Preview(uiMode = UI_MODE_NIGHT_YES, name = "Dark Mode", showBackground = false)
//@Composable
//private fun WorstSurfaceDarkPreview() {
//    WorstCard(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        WorstText(
//            text = "🌙 Night Mode Card",
//            style = MaterialTheme.typography.titleMedium,
//            modifier = Modifier.padding(bottom = 8.dp)
//        )
//        WorstText(
//            text = "Dark mode activated! Looking slick with proper contrast and themed colors that make this card pop.",
//            modifier = Modifier.padding(bottom = 12.dp)
//        )
//        WorstButton(
//            onClick = {},
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            WorstText(text = "ENGAGE SECRET WEAPON! 🧀")
//        }
//    }
//}