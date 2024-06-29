package ru.hackathone.stocksystem.staff.list

import android.content.res.Resources
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.hackathone.core.inventoryApi.exceptions.BadRequestException
import ru.hackathone.core.inventoryApi.exceptions.UnknownStatusCodeException
import ru.hackathone.core.inventoryApi.staff.service.StaffService
import ru.hackathone.core.message.data.MessageService
import ru.hackathone.core.message.domain.Message
import ru.hackathone.core.storage.SettingsStorage
import ru.hackathone.core.utils.StaffRole
import ru.hackathone.core.utils.USER_PATH
import ru.hackathone.core.utils.componentScope
import ru.hackathone.stocksystem.order.list.OrderListState
import ru.hackathone.stocksystem.order.list.RealOrderListComponent
import ru.hackathone.stocksystem.staff.list.toolbar.RealStaffListToolbarComponent

class RealStaffListComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val onDetails: () -> Unit,
    private val service: StaffService,
    private val messageService: MessageService,
    private val storage: SettingsStorage
) : ComponentContext by componentContext, StaffListComponent {

    private val componentInstance = instanceKeeper.getOrCreate(RealStaffListComponent::StaffListKeeper)

    override val toolbarComponent = RealStaffListToolbarComponent(
        componentContext = componentContext,
        onBack = onBack,
        onRefresh = { this.refreshStaff() }
    )
    override val viewState get() = componentInstance.viewState

    override fun onAddStaffClick() {
        messageService.showMessage(Message("Not yet implemented"))
    }

    private class StaffListKeeper :  InstanceKeeper.Instance {
        val viewState = MutableStateFlow<StaffListState>(StaffListState.Idle)

        override fun onDestroy() = Unit
    }

    private fun refreshStaff() {
        viewState.update { StaffListState.Loading }

        componentScope.launch {
            try {

                val staff = service.getStaffList()

                if (staff.isEmpty()) {
                    viewState.update { StaffListState.NoItems }
                    return@launch
                }

                viewState.update { StaffListState.Display(staff.asList()) }

            } catch (ex: Resources.NotFoundException) {
                messageService.showMessage(Message(text = "Not Found!"))
                viewState.update { StaffListState.Idle }
            } catch (ex: BadRequestException) {
                messageService.showMessage(Message(text = "Bad Request!"))
                viewState.update { StaffListState.Idle }
            } catch (ex: UnknownStatusCodeException) {
                messageService.showMessage(Message(text = "Unknown Status Code!"))
                viewState.update { StaffListState.Idle }
            }

            return@launch
        }
    }
}