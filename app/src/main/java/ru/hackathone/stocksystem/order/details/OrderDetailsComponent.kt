package ru.hackathone.stocksystem.order.details

import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.core.inventoryApi.staff.models.Staff
import ru.hackathone.core.inventoryApi.staff.models.TaskStatus
import ru.hackathone.stocksystem.order.details.toolbar.OrderDetailsToolbarComponent

interface OrderDetailsComponent {

    val toolbarComponent: OrderDetailsToolbarComponent

    val roleId: StateFlow<Int>

    val description: StateFlow<String>
    val statusId: StateFlow<Int>
    val statusName: StateFlow<String>
    val title: StateFlow<String>
    val userId: StateFlow<Int>
    val userName: StateFlow<String>

    val statuses: StateFlow<List<TaskStatus>>
    val users: StateFlow<List<Staff>>

    fun onTitleChange(newValue: String)
    fun onDescriptionChange(newValue: String)

    fun onStatusChange(newStatus: TaskStatus)
    fun onUserChange(newUser: Staff)
}