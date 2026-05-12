package com.worstkmp.di

/**
 * Simple example service interface.
 * Later this pattern will be used for CalibrationRepository, BluetoothRepository, etc.
 */
interface GreetingService {
    fun getWelcomeMessage(): String
}