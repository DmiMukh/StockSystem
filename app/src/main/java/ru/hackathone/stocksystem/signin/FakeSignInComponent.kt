package ru.hackathone.stocksystem.signin

import kotlinx.coroutines.flow.MutableStateFlow

class FakeSignInComponent : SignInComponent {
    override val login = MutableStateFlow("")

    override val password = MutableStateFlow("")

    override val inProgress = MutableStateFlow(false)

    override val passwordVisibility = MutableStateFlow(false)

    override fun onLoginChanged(login: String) = Unit

    override fun onPasswordChanged(password: String) = Unit
    override fun onVisibilityChanged(visibility: Boolean) = Unit

    override fun onSignInClick() = Unit
}