package ru.hackathone.stocksystem.home

import ru.hackathone.stocksystem.home.toolbar.FakeHomeToolbarComponent

class FakeHomeComponent : HomeComponent {

    override val toolbarComponent = FakeHomeToolbarComponent()
    override fun onOrderClick() = Unit

    override fun onProductClick() = Unit

    override fun onStaffClick() = Unit
}