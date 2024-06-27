package ru.hackathone.stocksystem.order.details.toolbar

import com.arkivanov.decompose.ComponentContext

class RealOrderDetailsToolbarComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit
) : ComponentContext by componentContext, OrderDetailsToolbarComponent {
    override fun onBackClick() = this.onBack.invoke()
}