package ru.hackathone.stocksystem.order.list

import ru.hackathone.core.inventoryApi.staff.models.Task

sealed class OrderListState {
    data class Display(val items: List<Task>) : OrderListState()
    object Loading: OrderListState()
    object NoItems: OrderListState()
}