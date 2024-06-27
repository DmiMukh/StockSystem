package ru.hackathone.stocksystem.settings

import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.stocksystem.settings.toolbar.SettingsToolbarComponent

interface SettingsComponent {

    val toolbarComponent: SettingsToolbarComponent

    val authServiceHost: StateFlow<String>
    val productServiceHost: StateFlow<String>
    val staffServiceHost: StateFlow<String>

    fun onAuthServiceHostChange(newValue: String)
    fun onProductServiceHostChange(newValue: String)
    fun onStaffServiceHostChange(newValue: String)
}