package ru.hackathone.stocksystem.order.list

import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.stocksystem.order.list.toolbar.OrderListToolbarComponent

interface OrderListComponent {

    val toolbarComponent: OrderListToolbarComponent

    val viewState: StateFlow<OrderListState>

}