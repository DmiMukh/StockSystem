package ru.hackathone.stocksystem.order.list

import ru.hackathone.stocksystem.order.list.toolbar.FakeOrderListToolbarComponent

class FakeOrderListComponent: OrderListComponent {
    override val toolbarComponent = FakeOrderListToolbarComponent()
}