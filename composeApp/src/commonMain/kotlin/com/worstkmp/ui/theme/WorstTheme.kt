package com.worstkmp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.worstkmp.ui.components.*

// ================================================================
// CUSTOM COLOR SCHEMES
// ================================================================
private val LightColorScheme = lightColorScheme(
    // Primary color: Main brand color used for prominent UI elements
    // Examples: Primary buttons, FABs, active states, progress indicators, selected tabs
    primary = Color(0xFFFF6500),

    // OnPrimary color: Text and icons displayed on top of primary color elements
    // Examples: Text on primary buttons, icons on FABs, content on primary-colored surfaces
    onPrimary = Color.Black,

    // Secondary color: Accent color for less prominent components
    // Examples: Secondary buttons, checkboxes, radio buttons, sliders, switches
    secondary = Color(0xFF4CAF50),

    // OnSecondary color: Text and icons displayed on top of secondary color elements
    // Examples: Text on secondary buttons, icons on checkboxes/radio buttons, labels on secondary-colored components
    onSecondary = Color.Black,

    // Background color: The backmost surface of the entire app
    // Examples: Main screen background in WorstSurface, scaffold background, bottom of all UI layers
    background = Color.White,              // Backmost element

    // Surface color: Color for elevated components that sit above the background
    // Examples: Cards, dialogs, menus, navigation drawers, sheets, elevated panels
    surface = Color(0xFFF5F5F5),           // Cards / panels

    // OnBackground color: Text and icons displayed on top of background
    // Examples: Main body text, app bar text when on background, icons on background
    onBackground = Color.Black,

    // OnSurface color: Text and icons displayed on top of surface elements
    // Examples: Text in cards, dialog content text, menu item text, drawer items
    onSurface = Color.Black,
    
    // Outline color: Color used for borders and dividers on surface elements in dark mode
    // Examples: Card borders, text field outlines, dividers, component boundaries
    outline = Color(0xFF81C784),        // Subtle borders

    // PrimaryContainer color: A tonal variation of primary color for containers and grouped elements
    // Examples: Tonal buttons, chip containers, selected navigation items, grouped primary elements
    primaryContainer = Color(0xFFFF6C1A),

    // OnPrimaryContainer color: Text and icons displayed on top of primaryContainer color elements
    // Examples: Text on tonal buttons, icons in chip containers, labels on primary container surfaces
    onPrimaryContainer = Color.Black,
)
private val DarkColorScheme = darkColorScheme(
    // Primary color: Main brand color used for prominent UI elements (adjusted for dark mode contrast)
    // Examples: Primary buttons, FABs, active states, progress indicators, selected tabs
    primary = Color(0xFFE75B00),

    // OnPrimary color: Text and icons displayed on top of primary color elements
    // Examples: Text on primary buttons, icons on FABs, content on primary-colored surfaces
    onPrimary = Color.White,

    // Secondary color: Accent color for less prominent components (adjusted for dark mode)
    // Examples: Secondary buttons, checkboxes, radio buttons, sliders, switches
    secondary = Color(0xFF81C784),

    // OnSecondary color: Text and icons displayed on top of secondary color elements
    // Examples: Text on secondary buttons, icons on checkboxes/radio buttons, labels on secondary-colored components
    onSecondary = Color.White,

    // Background color: The backmost surface of the entire app in dark mode
    // Examples: Main screen background in WorstSurface, scaffold background, bottom of all UI layers
    background = Color(0xFF121212),        // Backmost element

    // Surface color: Color for elevated components that sit above the dark background
    // Examples: Cards, dialogs, menus, navigation drawers, sheets, elevated panels (slightly lighter than background for depth)
    surface = Color(0xFF1E1E1E),           // Cards

    // OnBackground color: Text and icons displayed on top of dark background
    // Examples: Main body text, app bar text when on background, icons on background
    onBackground = Color.White,

    // OnSurface color: Text and icons displayed on top of dark surface elements
    // Examples: Text in cards, dialog content text, menu item text, drawer items
    onSurface = Color.White,

    // Outline color: Color used for borders and dividers on surface elements in dark mode
    // Examples: Card borders, text field outlines, dividers, component boundaries
    outline = Color(0xFF3A3A3C),        // Subtle dark mode borders

    // PrimaryContainer color: A tonal variation of primary color for containers and grouped elements
    // Examples: Tonal buttons, chip containers, selected navigation items, grouped primary elements
    primaryContainer = Color(0xFFD24C00),

    // OnPrimaryContainer color: Text and icons displayed on top of primaryContainer color elements
    // Examples: Text on tonal buttons, icons in chip containers, labels on primary container surfaces
    onPrimaryContainer = Color.White,
)



@Composable
public fun getWorstColorScheme(): ColorScheme {
    val darkTheme: Boolean = isSystemInDarkTheme()
    val worstColorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    return worstColorScheme
}

// ================================================================
// CUSTOM TYPOGRAPHY
// ================================================================
private val WorstTypography = Typography(
    headlineLarge = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold),
    headlineMedium = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.SemiBold),
    titleLarge = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.SemiBold),
    bodyLarge = TextStyle(fontSize = 16.sp),
    labelLarge = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
)

@Composable
public fun getWorstTypography(): Typography {
    return WorstTypography
}

// ================================================================
// CUSTOM SHAPES (rounded corners, etc.)
// ================================================================
private val WorstShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
    large = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
)

@Composable
public fun getWorstShapes(): Shapes {
    return WorstShapes
}

// ================================================================
// THEME WRAPPER (Wraps the entire app with custom Material 3 theming)
// ================================================================
@Composable
fun WorstTheme(
    content: @Composable () -> Unit
) {
    // Select the appropriate color scheme based on dark mode preference
    val worstColorScheme = getWorstColorScheme()

    // Apply Material 3 theming with the selected color scheme to all child composables
    MaterialTheme(
        colorScheme = worstColorScheme,
        typography = WorstTypography,
        shapes = WorstShapes,
        content = content
    )
}

// ================================================================
// THEME ACCESSORS (Allow access to theme properties from anywhere)
// ================================================================
object WorstTheme {
    val colors: ColorScheme
        @Composable
        get() = getWorstColorScheme()

    val typography: Typography
        @Composable
        get() = getWorstTypography()

    val shapes: Shapes
        @Composable
        get() = getWorstShapes()
}

// ================================================================
// Example Previews
// ================================================================
@Preview
@Composable
private fun WorstSurfacePreview() {
    WorstTheme {
        WorstSurface {
            WorstCard {
                WorstText(
                    text = "WorstSurface Preview",
                    style = MaterialTheme.typography.headlineMedium
                )
                WorstButton(
                    onClick = {}
                ) {
                    WorstText(text = "Click Me")
                }
            }
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun WorstSurfaceDarkPreview() {
    WorstTheme {
        WorstSurface {
            WorstCard {
                WorstText(
                    text = "WorstSurface Preview",
                    style = MaterialTheme.typography.headlineMedium
                )
                WorstButton(
                    onClick = {}
                ) {
                    WorstText(text = "Click Me")
                }
            }
        }
    }
}