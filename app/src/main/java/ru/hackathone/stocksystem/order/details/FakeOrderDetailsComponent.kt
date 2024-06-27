package ru.hackathone.stocksystem.order.details

import ru.hackathone.stocksystem.order.details.toolbar.FakeOrderDetailsToolbarComponent

class FakeOrderDetailsComponent: OrderDetailsComponent {
    override val toolbarComponent = FakeOrderDetailsToolbarComponent()
}