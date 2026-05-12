package com.worstkmp.di

class GreetingServiceImpl : GreetingService {
    override fun getWelcomeMessage(): String {
        return "Welcome to the WorstKMP Prototype!\nThis message came from Koin."
    }
}