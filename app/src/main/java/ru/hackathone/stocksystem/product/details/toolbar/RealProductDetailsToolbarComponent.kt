package ru.hackathone.stocksystem.product.details.toolbar

import com.arkivanov.decompose.ComponentContext

class RealProductDetailsToolbarComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val onSave: () -> Unit
) : ComponentContext by componentContext, ProductDetailsToolbarComponent {
    override fun onBackClick() = onBack.invoke()

    override fun onSaveClick() = onSave.invoke()
}