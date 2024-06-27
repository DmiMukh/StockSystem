package ru.hackathone.stocksystem.home

import com.arkivanov.decompose.ComponentContext
import ru.hackathone.stocksystem.home.toolbar.RealHomeToolbarComponent

class RealHomeComponent(
    componentContext: ComponentContext,
    private val onProduct: () -> Unit,
    private val onStaff: () -> Unit
) : ComponentContext by componentContext, HomeComponent {

    override val toolbarComponent = RealHomeToolbarComponent(
        componentContext = componentContext
    )

    override fun onProductClick() = this.onProduct.invoke()

    override fun onStaffClick()  = this.onStaff.invoke()
}