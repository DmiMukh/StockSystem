package ru.hackathone.stocksystem.order.details

import kotlinx.coroutines.flow.MutableStateFlow
import ru.hackathone.stocksystem.order.details.toolbar.FakeOrderDetailsToolbarComponent

class FakeOrderDetailsComponent: OrderDetailsComponent {
    override val toolbarComponent = FakeOrderDetailsToolbarComponent()
    override val roleId = MutableStateFlow(0)
    override val description = MutableStateFlow("")
    override val title = MutableStateFlow("")
    override fun onTitleChange(newValue: String) = Unit

    override fun onDescriptionChange(newValue: String) = Unit
}