package ru.hackathone.stocksystem.order.list

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.flow.MutableStateFlow
import ru.hackathone.core.inventoryApi.staff.service.StaffService
import ru.hackathone.stocksystem.order.list.toolbar.RealOrderListToolbarComponent

class RealOrderListComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val service: StaffService
) : ComponentContext by componentContext, OrderListComponent {

    private val componentInstance = instanceKeeper.getOrCreate(RealOrderListComponent::OrderListKeeper)

    override val toolbarComponent = RealOrderListToolbarComponent(
        componentContext = componentContext,
        onBack = this.onBack
    )
    override val viewState get() = componentInstance.viewState

    private class OrderListKeeper :  InstanceKeeper.Instance {
        val viewState = MutableStateFlow<OrderListState>(OrderListState.NoItems)

        override fun onDestroy() = Unit
    }
}