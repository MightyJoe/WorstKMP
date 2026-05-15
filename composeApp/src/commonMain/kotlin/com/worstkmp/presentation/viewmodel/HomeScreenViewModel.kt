package com.worstkmp.presentation.viewmodel

import cafe.adriel.voyager.core.model.ScreenModel
import com.worstkmp.di.GreetingService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeScreenViewModel : ScreenModel, KoinComponent {


    // This is the Koin magic — it automatically gives us the service
    private val greetingService: GreetingService by inject()

    fun getWelcomeMessage(): String {
        return greetingService.getWelcomeMessage()
    }
}