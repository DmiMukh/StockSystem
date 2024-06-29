package ru.hackathone.stocksystem.order.list.toolbar

import com.arkivanov.decompose.ComponentContext

class RealOrderListToolbarComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val onRefresh: () -> Unit
) : ComponentContext by componentContext, OrderListToolbarComponent {
    override fun onBackClick() = this.onBack.invoke()
    override fun onRefreshClick() = this.onRefresh.invoke()
}