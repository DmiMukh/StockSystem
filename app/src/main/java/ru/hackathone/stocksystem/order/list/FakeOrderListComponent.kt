package ru.hackathone.stocksystem.order.list

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.core.inventoryApi.staff.models.Task
import ru.hackathone.stocksystem.order.list.toolbar.FakeOrderListToolbarComponent

class FakeOrderListComponent: OrderListComponent {
    override val toolbarComponent = FakeOrderListToolbarComponent()
    override val viewState = MutableStateFlow<OrderListState>(OrderListState.NoItems)
    override val roleId = MutableStateFlow(0)

    override fun onAddOrderClick() = Unit
    override fun onOrderClick(task: Task) = Unit
    override fun onRemoveOrder(task: Task) = Unit
}