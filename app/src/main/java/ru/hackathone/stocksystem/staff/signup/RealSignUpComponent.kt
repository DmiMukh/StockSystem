package ru.hackathone.stocksystem.staff.signup

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.hackathone.core.inventoryApi.staff.models.Staff
import ru.hackathone.core.inventoryApi.staff.service.StaffService
import ru.hackathone.core.inventoryApi.userAuth.service.AuthorizationService
import ru.hackathone.core.message.data.MessageService
import ru.hackathone.core.message.domain.Message
import ru.hackathone.core.utils.componentScope
import ru.hackathone.stocksystem.staff.signup.toolbar.RealSignUpToolbarComponent

class RealSignUpComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val authService: AuthorizationService,
    private val staffService: StaffService,
    private val messageService: MessageService
) : ComponentContext by componentContext, SignUpComponent {

    private val componentInstance = instanceKeeper.getOrCreate(RealSignUpComponent::SignUpKeeper)
    override val toolbarComponent = RealSignUpToolbarComponent(
        componentContext = componentContext,
        onBack = {onBack()},
        onSave = {
            componentScope.launch {
                val id = authService.signUp(
                    fullName = fullName.value,
                    login = login.value,
                    password = password.value,
                    roleId = roleId.value
                )

                messageService.showMessage(Message(text = "User created with id=$id!"))

                onBack.invoke()
            }
        }
    )

    override val fullName get() = componentInstance.fullName
    override val login get() = componentInstance.login
    override val password get() = componentInstance.password
    override val roleId get() = componentInstance.roleId
    override val roleName get() = componentInstance.roleName
    override val roles get() = componentInstance.roles

    override fun onFullNameChange(newValue: String) {
        fullName.value = newValue
    }

    override fun onLoginChange(newValue: String) {
        login.value = newValue
    }

    override fun onPasswordChange(newValue: String) {
        password.value = newValue
    }

    override fun onRoleChange(newValue: Pair<Int, String>) {
        roleId.value = newValue.first
        roleName.value = newValue.second
    }

    private class SignUpKeeper :  InstanceKeeper.Instance {
        val fullName = MutableStateFlow("")
        val login = MutableStateFlow("")
        val password = MutableStateFlow("")
        val roleId = MutableStateFlow(0)
        val roleName = MutableStateFlow("")

        val roles = MutableStateFlow(listOf(
            Pair(1, "ADMIN"),
            Pair(2, "MANAGER"),
            Pair(3, "WORKER")
        ))

        override fun onDestroy() = Unit
    }
}