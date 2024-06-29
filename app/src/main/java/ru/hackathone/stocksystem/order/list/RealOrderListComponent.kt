package ru.hackathone.stocksystem.order.list

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import android.content.res.Resources.NotFoundException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.core.inventoryApi.exceptions.BadRequestException
import ru.hackathone.core.inventoryApi.exceptions.UnknownStatusCodeException
import ru.hackathone.core.inventoryApi.staff.models.Task
import ru.hackathone.core.inventoryApi.staff.service.StaffService
import ru.hackathone.core.message.data.MessageService
import ru.hackathone.core.message.domain.Message
import ru.hackathone.core.storage.SettingsStorage
import ru.hackathone.core.utils.ROLE_PATH
import ru.hackathone.core.utils.componentScope
import ru.hackathone.stocksystem.order.list.toolbar.RealOrderListToolbarComponent

class RealOrderListComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val onDetails: (Task) -> Unit,
    private val service: StaffService,
    private val messageService: MessageService,
    private val storage: SettingsStorage
) : ComponentContext by componentContext, OrderListComponent {

    private val componentInstance = instanceKeeper.getOrCreate(RealOrderListComponent::OrderListKeeper)

    override val toolbarComponent = RealOrderListToolbarComponent(
        componentContext = componentContext,
        onBack = this.onBack,
        onRefresh = { this.refreshOrders() }
    )
    override val viewState get() = componentInstance.viewState
    override val roleId = MutableStateFlow(100)

    override fun onAddOrderClick() {
        this.onDetails.invoke(Task())
    }

    override fun onOrderClick(task: Task) {
        this.onDetails.invoke(task)
    }

    private class OrderListKeeper :  InstanceKeeper.Instance {
        val viewState = MutableStateFlow<OrderListState>(OrderListState.Idle)

        override fun onDestroy() = Unit
    }

    private fun refreshOrders() {

        viewState.update { OrderListState.Loading }

        componentScope.launch {
            try {
                val tasks = service.getTaskList()

                if (tasks.size == 0) {
                    viewState.update { OrderListState.NoItems }
                    return@launch
                }

                viewState.update { OrderListState.Display(tasks.asList()) }

            } catch (ex: NotFoundException) {
                messageService.showMessage(Message(text = "Not Found!"))
                viewState.update { OrderListState.Idle }
            } catch (ex: BadRequestException) {
                messageService.showMessage(Message(text = "Bad Request!"))
                viewState.update { OrderListState.Idle }
            } catch (ex: UnknownStatusCodeException) {
                messageService.showMessage(Message(text = "Unknown Status Code!"))
                viewState.update { OrderListState.Idle }
            }

            return@launch
        }
    }

    init {
        roleId.value = this.storage.getInt(ROLE_PATH)
    }
}