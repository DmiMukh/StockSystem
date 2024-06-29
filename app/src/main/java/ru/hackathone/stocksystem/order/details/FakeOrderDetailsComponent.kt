package ru.hackathone.stocksystem.order.details

import kotlinx.coroutines.flow.MutableStateFlow
import ru.hackathone.core.inventoryApi.staff.models.Staff
import ru.hackathone.core.inventoryApi.staff.models.TaskStatus
import ru.hackathone.stocksystem.order.details.toolbar.FakeOrderDetailsToolbarComponent

class FakeOrderDetailsComponent: OrderDetailsComponent {
    override val toolbarComponent = FakeOrderDetailsToolbarComponent()
    override val roleId = MutableStateFlow(0)
    override val description = MutableStateFlow("")
    override val statusId = MutableStateFlow(0)
    override val statusName = MutableStateFlow("")
    override val title = MutableStateFlow("")
    override val userId = MutableStateFlow(0)
    override val userName = MutableStateFlow("")
    override val statuses = MutableStateFlow(emptyList<TaskStatus>())
    override val users = MutableStateFlow(emptyList<Staff>())

    override fun onTitleChange(newValue: String) = Unit

    override fun onDescriptionChange(newValue: String) = Unit
    override fun onStatusChange(newStatus: TaskStatus) = Unit

    override fun onUserChange(newUser: Staff) = Unit
}