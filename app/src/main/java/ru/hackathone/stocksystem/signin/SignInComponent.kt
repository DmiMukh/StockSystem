package ru.hackathone.stocksystem.signin

import kotlinx.coroutines.flow.StateFlow

interface SignInComponent {

    val login: StateFlow<String>

    val password: StateFlow<String>

    val inProgress: StateFlow<Boolean>

    val passwordVisibility: StateFlow<Boolean>


    fun onLoginChanged(login: String)

    fun onPasswordChanged(password: String)

    fun onVisibilityChanged(visibility: Boolean)
    fun onSignInClick()

}