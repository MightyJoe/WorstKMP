package com.worstkmp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

// custom color palette
private val LightColorScheme = lightColorScheme(
    // Primary color: Main brand color used for prominent UI elements
    // Examples: Primary buttons, FABs, active states, progress indicators, selected tabs
    primary = Color(0xFFFF6600),

    // OnPrimary color: Text and icons displayed on top of primary color elements
    // Examples: Text on primary buttons, icons on FABs, content on primary-colored surfaces
    onPrimary = Color.Black,

    // Secondary color: Accent color for less prominent components
    // Examples: Secondary buttons, checkboxes, radio buttons, sliders, switches
    secondary = Color(0xFF4CAF50),

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
)

@Composable
fun WorstTheme(
    // Whether to use dark or light theme; defaults to system preference
    darkTheme: Boolean = isSystemInDarkTheme(),
    // The composable content to be themed
    content: @Composable () -> Unit
) {
    // Select the appropriate color scheme based on dark mode preference
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    // Apply Material 3 theming with the selected color scheme to all child composables
    MaterialTheme(
        colorScheme = colorScheme,
        typography = androidx.compose.material3.Typography(), //TODO Customize fonts
        content = content
    )
}

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
                    text = "Click Me",
                    onClick = {}
                )
            }
        }
    }
}

@Preview
@Composable
private fun WorstSurfaceDarkPreview() {
    WorstTheme(darkTheme = true) {
        WorstSurface {
            WorstCard {
                WorstText(
                    text = "WorstSurface Preview",
                    style = MaterialTheme.typography.headlineMedium
                )
                WorstButton(
                    text = "Click Me",
                    onClick = {}
                )
            }
        }
    }
}