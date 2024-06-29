package ru.hackathone.stocksystem.product.list.toolbar

import com.arkivanov.decompose.ComponentContext

class RealProductListToolbarComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val onRefresh: () -> Unit
) : ComponentContext by componentContext, ProductListToolbarComponent {
    override fun onBackClick() = onBack.invoke()
    override fun onRefreshClick() = onRefresh.invoke()

}