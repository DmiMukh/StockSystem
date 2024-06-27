package ru.hackathone.stocksystem.product.list

import com.arkivanov.decompose.ComponentContext
import ru.hackathone.stocksystem.product.list.toolbar.RealProductListToolbarComponent

class RealProductListComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit
) : ComponentContext by componentContext,  ProductListComponent {

    override val toolbarComponent = RealProductListToolbarComponent(
        componentContext = componentContext,
        onBack = { onBack.invoke() }
    )

}