package ru.hackathone.stocksystem.signin.toolbar

import com.arkivanov.decompose.ComponentContext

class RealSignInToolbarComponent(
    componentContext: ComponentContext,
    private val onSettings: () -> Unit
): ComponentContext by componentContext,  SignInToolbarComponent {
    override fun onSettingsClick() = this.onSettings.invoke()
}