package ru.hackathone.stocksystem.staff.signup

import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.stocksystem.staff.signup.toolbar.SignUpToolbarComponent

interface SignUpComponent {

    val toolbarComponent: SignUpToolbarComponent

    val fullName: StateFlow<String>
    val login: StateFlow<String>
    val password: StateFlow<String>
    val roleId: StateFlow<Int>
    val roleName: StateFlow<String>

    val roles: StateFlow<List<Pair<Int, String>>>

    fun onFullNameChange(newValue: String)
    fun onLoginChange(newValue: String)
    fun onPasswordChange(newValue: String)
    fun onRoleChange(newValue: Pair<Int, String>)
}