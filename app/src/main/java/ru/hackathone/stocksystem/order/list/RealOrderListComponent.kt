package ru.hackathone.stocksystem.order.list

import com.arkivanov.decompose.ComponentContext
import ru.hackathone.core.inventoryApi.staff.service.StaffService
import ru.hackathone.stocksystem.order.list.toolbar.RealOrderListToolbarComponent

class RealOrderListComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val service: StaffService
) : ComponentContext by componentContext, OrderListComponent {
    override val toolbarComponent = RealOrderListToolbarComponent(
        componentContext = componentContext,
        onBack = this.onBack
    )
}