package ru.hackathone.stocksystem.order.details.toolbar

import com.arkivanov.decompose.ComponentContext

class RealOrderDetailsToolbarComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val onSave: () -> Unit
) : ComponentContext by componentContext, OrderDetailsToolbarComponent {
    override fun onBackClick() = this.onBack.invoke()
    override fun onSaveClick() = this.onSave.invoke()
}