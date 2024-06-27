package ru.hackathone.stocksystem.signin

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.hackathone.core.utils.componentCoroutineScope

class RealSignInComponent(
    componentContext: ComponentContext,
    private val onSignInComplete: () -> Unit
) : ComponentContext by componentContext, SignInComponent {

    override val login = MutableStateFlow("")

    override val password = MutableStateFlow("")

    override val inProgress = MutableStateFlow(false)

    override val passwordVisibility = MutableStateFlow(false)

    private val coroutineScope = componentCoroutineScope()


    override fun onLoginChanged(login: String) {
        this.login.value = login
    }

    override fun onPasswordChanged(password: String) {
        this.password.value = password
    }

    override fun onVisibilityChanged(visibility: Boolean) {
        this.passwordVisibility.value = visibility;
    }

    override fun onSignInClick() {
        coroutineScope.launch {
            inProgress.value = true
            delay(3000)
            //TODO("Авторизация через репозиторий")
            inProgress.value = false

            onSignInComplete.invoke()
        }
    }
}