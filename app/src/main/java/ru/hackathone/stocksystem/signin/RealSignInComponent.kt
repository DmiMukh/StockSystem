package ru.hackathone.stocksystem.signin

import android.content.res.Resources.NotFoundException
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.hackathone.core.inventoryApi.exceptions.BadRequestException
import ru.hackathone.core.inventoryApi.exceptions.UnknownStatusCodeException
import ru.hackathone.core.inventoryApi.userAuth.service.AuthorizationService
import ru.hackathone.core.message.data.MessageService
import ru.hackathone.core.message.domain.Message
import ru.hackathone.core.storage.SettingsStorage
import ru.hackathone.core.utils.TOKEN
import ru.hackathone.core.utils.componentCoroutineScope
import ru.hackathone.stocksystem.signin.toolbar.RealSignInToolbarComponent

class RealSignInComponent(
    componentContext: ComponentContext,
    private val onSettings: () -> Unit,
    private val onSignInComplete: () -> Unit,
    private val service: AuthorizationService,
    private val messageService: MessageService,
    private val storage: SettingsStorage
) : ComponentContext by componentContext, SignInComponent {
    override val toolbarComponent = RealSignInToolbarComponent(
        componentContext = componentContext,
        onSettings = this.onSettings
    )

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
        this.passwordVisibility.value = visibility
    }

    override fun onSignInClick() {
        coroutineScope.launch {
            inProgress.value = true
            try {
                val token = service.signIn(login.value, password.value)
                storage.putString(TOKEN, token)
            } catch (e: BadRequestException) {
                messageService.showMessage(Message("Bad Request"))
                return@launch
            } catch (e: NotFoundException) {
                messageService.showMessage(Message("Not Found"))
                return@launch
            } catch (e: UnknownStatusCodeException) {
                messageService.showMessage(Message("Unknown Status Code"))
                return@launch
            } catch (e: Exception) {
                messageService.showMessage(Message(e.message.orEmpty()))
                return@launch
            }
            finally {
                inProgress.value = false
            }

            onSignInComplete.invoke()
            return@launch
        }
    }
}