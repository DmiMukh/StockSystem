package ru.hackathone.stocksystem.staff.signup

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.core.inventoryApi.userAuth.service.AuthorizationService
import ru.hackathone.core.message.data.MessageService
import ru.hackathone.core.utils.AUTH_HOST_PATH
import ru.hackathone.core.utils.PRODUCT_HOST_PATH
import ru.hackathone.core.utils.STAFF_HOST_PATH
import ru.hackathone.stocksystem.staff.list.RealStaffListComponent
import ru.hackathone.stocksystem.staff.list.StaffListState
import ru.hackathone.stocksystem.staff.list.toolbar.RealStaffListToolbarComponent
import ru.hackathone.stocksystem.staff.list.toolbar.StaffListToolbarComponent
import ru.hackathone.stocksystem.staff.signup.toolbar.RealSignUpToolbarComponent

class RealSignUpComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val service: AuthorizationService,
    private val messageService: MessageService
) : ComponentContext by componentContext, SignUpComponent {

    private val componentInstance = instanceKeeper.getOrCreate(RealSignUpComponent::SignUpKeeper)
    override val toolbarComponent = RealSignUpToolbarComponent(
        componentContext = componentContext,
        onBack = {onBack()},
        onSave = {}
    )

    override val fullName get() = componentInstance.fullName
    override val login get() = componentInstance.login
    override val password get() = componentInstance.password
    override val roleId get() = componentInstance.roleId
    override val roleName get() = componentInstance.roleName
    override fun onFullNameChange(newValue: String) {
        fullName.value = newValue
    }

    override fun onLoginChange(newValue: String) {
        login.value = newValue
    }

    override fun onPasswordChange(newValue: String) {
        password.value = newValue
    }

    private class SignUpKeeper :  InstanceKeeper.Instance {
        val fullName = MutableStateFlow("")
        val login = MutableStateFlow("")
        val password = MutableStateFlow("")
        val roleId = MutableStateFlow(0)
        val roleName = MutableStateFlow("")
        override fun onDestroy() = Unit
    }
}