package ru.hackathone.stocksystem.order.details

import kotlinx.coroutines.flow.MutableStateFlow
import ru.hackathone.stocksystem.order.details.toolbar.FakeOrderDetailsToolbarComponent

class FakeOrderDetailsComponent: OrderDetailsComponent {
    override val toolbarComponent = FakeOrderDetailsToolbarComponent()
    override val description = MutableStateFlow("")
    override val title = MutableStateFlow("")
}