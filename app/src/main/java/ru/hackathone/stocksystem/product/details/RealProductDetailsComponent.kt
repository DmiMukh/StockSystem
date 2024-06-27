package ru.hackathone.stocksystem.product.details

import com.arkivanov.decompose.ComponentContext
import ru.hackathone.stocksystem.product.details.toolbar.RealProductDetailsToolbarComponent

class RealProductDetailsComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit
) : ComponentContext by componentContext, ProductDetailsComponent {
    override val toolbarComponent = RealProductDetailsToolbarComponent(
        componentContext = componentContext,
        onBack = { onBack.invoke() },
        onSave = { TODO("Add Save") }
    )
}