package ru.hackathone.stocksystem.order.details

import com.arkivanov.decompose.ComponentContext
import ru.hackathone.stocksystem.order.details.toolbar.RealOrderDetailsToolbarComponent

class RealOrderDetailsComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit
) : ComponentContext by componentContext, OrderDetailsComponent {
    override val toolbarComponent = RealOrderDetailsToolbarComponent(
        componentContext = componentContext,
        onBack = this.onBack
    )
}