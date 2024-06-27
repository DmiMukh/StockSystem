package ru.hackathone.stocksystem.signin

import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.stocksystem.signin.toolbar.SignInToolbarComponent

interface SignInComponent {

    val toolbarComponent: SignInToolbarComponent

    val login: StateFlow<String>

    val password: StateFlow<String>

    val inProgress: StateFlow<Boolean>

    val passwordVisibility: StateFlow<Boolean>

    fun onLoginChanged(login: String)

    fun onPasswordChanged(password: String)

    fun onVisibilityChanged(visibility: Boolean)

    fun onSignInClick()

}