package ru.hackathone.stocksystem.order

import com.arkivanov.decompose.ComponentContext
import ru.hackathone.core.ComponentFactory
import ru.hackathone.stocksystem.order.details.OrderDetailsComponent
import ru.hackathone.stocksystem.order.details.RealOrderDetailsComponent
import ru.hackathone.stocksystem.order.list.OrderListComponent
import ru.hackathone.stocksystem.order.list.RealOrderListComponent
import ru.hackathone.stocksystem.order.root.OrderRootComponent
import ru.hackathone.stocksystem.order.root.RealOrderRootComponent
import org.koin.core.component.get

fun ComponentFactory.createOrderRootComponent(
    componentContext: ComponentContext,
    onBack: () -> Unit
) : OrderRootComponent {
    return RealOrderRootComponent(
        componentContext = componentContext,
        onBack = onBack,
        componentFactory = get()
    )
}

fun ComponentFactory.createOrderDetailsComponent(
    componentContext: ComponentContext,
    onBack: () -> Unit
) : OrderDetailsComponent {
    return RealOrderDetailsComponent(
        componentContext = componentContext,
        onBack = onBack
    )
}
fun ComponentFactory.createOrderListComponent(
    componentContext: ComponentContext,
    onBack: () -> Unit
) : OrderListComponent {
    return RealOrderListComponent(
        componentContext = componentContext,
        onBack = onBack
    )
}