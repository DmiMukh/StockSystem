package ru.hackathone.stocksystem.order.root

import com.arkivanov.decompose.router.stack.ChildStack
import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.stocksystem.order.details.OrderDetailsComponent
import ru.hackathone.stocksystem.order.list.OrderListComponent

interface OrderRootComponent {
    val childStack: StateFlow<ChildStack<*, OrderRootComponent.Child>>

    sealed interface Child {
        class Details(val component: OrderDetailsComponent) : OrderRootComponent.Child
        class List(val component: OrderListComponent) : OrderRootComponent.Child
    }
}