package ru.hackathone.stocksystem.home

import kotlinx.coroutines.flow.MutableStateFlow
import ru.hackathone.stocksystem.home.toolbar.FakeHomeToolbarComponent

class FakeHomeComponent : HomeComponent {

    override val toolbarComponent = FakeHomeToolbarComponent()
    override val roleId = MutableStateFlow(0)

    override fun onOrderClick() = Unit

    override fun onProductClick() = Unit

    override fun onStaffClick() = Unit
}