package ru.hackathone.stocksystem.home.toolbar

import com.arkivanov.decompose.ComponentContext

class RealHomeToolbarComponent(
    componentContext: ComponentContext,
    private val onLogOut: () -> Unit
) : ComponentContext by componentContext, HomeToolbarComponent {
    override fun onLogOut() = this.onLogOut.invoke()
}