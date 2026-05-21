//package com.worstprogrammer.worstkmp
//
//import androidx.compose.ui.window.ComposeUIViewController
//
//fun MainViewController() = ComposeUIViewController {
//    if (GlobalContext.getOrNull() == null) {
//        startKoin {
//            modules(appModule)
//        }
//    }
//
//    App()
//}

package com.worstkmp

import androidx.compose.ui.window.ComposeUIViewController
import com.worstkmp.ui.screens.HomeScreen

/**
 * This is the entry point called from Swift.
 * It creates a Compose UI view controller that hosts our root screen.
 */
fun MainViewController() = ComposeUIViewController {
    // For now we keep it simple — no Koin yet.
    // We'll wire Koin properly once iOS is building cleanly.
    HomeScreen()
}