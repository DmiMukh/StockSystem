package ru.hackathone.stocksystem.order.details

import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.stocksystem.order.details.toolbar.OrderDetailsToolbarComponent

interface OrderDetailsComponent {

    val toolbarComponent: OrderDetailsToolbarComponent

    val roleId: StateFlow<Int>

    val description: StateFlow<String>
    val title: StateFlow<String>

    fun onTitleChange(newValue: String)
    fun onDescriptionChange(newValue: String)
}