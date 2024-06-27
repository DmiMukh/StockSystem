package ru.hackathone.stocksystem.settings

import kotlinx.coroutines.flow.MutableStateFlow
import ru.hackathone.stocksystem.settings.toolbar.FakeSettingsToolbarComponent

class FakeSettingsComponent: SettingsComponent {
    override val toolbarComponent = FakeSettingsToolbarComponent()

    override val authServiceHost = MutableStateFlow("127.0.0.1:5050")
    override val productServiceHost = MutableStateFlow("127.0.0.1:5051")
    override val staffServiceHost = MutableStateFlow("127.0.0.1:5052")

    override fun onAuthServiceHostChange(newValue: String) = Unit

    override fun onProductServiceHostChange(newValue: String) = Unit

    override fun onStaffServiceHostChange(newValue: String) = Unit
}