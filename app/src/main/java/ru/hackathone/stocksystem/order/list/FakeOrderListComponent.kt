package ru.hackathone.stocksystem.order.list

import kotlinx.coroutines.flow.MutableStateFlow
import ru.hackathone.stocksystem.order.list.toolbar.FakeOrderListToolbarComponent

class FakeOrderListComponent: OrderListComponent {
    override val toolbarComponent = FakeOrderListToolbarComponent()
    override val viewState = MutableStateFlow<OrderListState>(OrderListState.NoItems)
}