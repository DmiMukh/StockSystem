package ru.hackathone.stocksystem.order.details

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.hackathone.core.inventoryApi.staff.dto.TaskRequest
import ru.hackathone.core.inventoryApi.staff.models.Staff
import ru.hackathone.core.inventoryApi.staff.models.Task
import ru.hackathone.core.inventoryApi.staff.models.TaskStatus
import ru.hackathone.core.inventoryApi.staff.service.StaffService
import ru.hackathone.core.message.data.MessageService
import ru.hackathone.core.message.domain.Message
import ru.hackathone.core.storage.SettingsStorage
import ru.hackathone.core.utils.ROLE_PATH
import ru.hackathone.core.utils.componentScope
import ru.hackathone.stocksystem.order.details.toolbar.RealOrderDetailsToolbarComponent

class RealOrderDetailsComponent(
    componentContext: ComponentContext,
    private val task: Task,
    private val onBack: () -> Unit,
    private val service: StaffService,
    private val messageService: MessageService,
    private val storage: SettingsStorage
) : ComponentContext by componentContext, OrderDetailsComponent {

    private val componentInstance = instanceKeeper.getOrCreate(RealOrderDetailsComponent::TaskKeeper)

    override val roleId = MutableStateFlow(100)

    override val toolbarComponent = RealOrderDetailsToolbarComponent(
        componentContext = componentContext,
        onBack = this.onBack,
        onSave = {
            val newTask = TaskRequest(
                title = title.value,
                description = description.value,
                statusId = statusId.value,
                userId = userId.value
            )

            componentScope.launch {
                if (task.id == -1) {
                    service.createTask(newTask)
                    messageService.showMessage(Message(text = "Task created!"))
                } else {
                    service.updateTask(task.id, newTask)
                    messageService.showMessage(Message(text = "Task updated!"))
                }

                onBack.invoke()
            }
        }
    )
    override val description get() = componentInstance.description
    override val statusId get() = componentInstance.statusId
    override val statusName get() = componentInstance.statusName
    override val title get() = componentInstance.title
    override val userId get() = componentInstance.userId
    override val userName get() = componentInstance.userName
    override val statuses get() = componentInstance.statuses
    override val users get() = componentInstance.users

    override fun onTitleChange(newValue: String) {
        title.value = newValue
    }

    override fun onDescriptionChange(newValue: String) {
        description.value = newValue
    }

    override fun onStatusChange(newStatus: TaskStatus) {
        statusId.value = newStatus.id
        statusName.value = newStatus.name
    }

    override fun onUserChange(newUser: Staff) {
        userId.value = newUser.id
        userName.value = newUser.fullName
    }

    private class TaskKeeper :  InstanceKeeper.Instance {

        val isInit = false

        val title = MutableStateFlow("")
        val description = MutableStateFlow("")

        val statusId = MutableStateFlow(0)
        val statusName = MutableStateFlow("")
        val userId = MutableStateFlow(0)
        val userName = MutableStateFlow("")

        val statuses = MutableStateFlow<List<TaskStatus>>(emptyList())
        val users = MutableStateFlow<List<Staff>>(emptyList())

        override fun onDestroy() = Unit
    }

    init {
        roleId.value = this.storage.getInt(ROLE_PATH)

        if(!componentInstance.isInit) {
            this.title.value = this.task.title
            this.description.value = this.task.description
            this.statusId.value = this.task.statusId
            this.userId.value = this.task.userId

            componentScope.launch {
                statuses.value = service.getStatusList().toList()
                statuses.value.forEach {
                    if (it.id == statusId.value) statusName.value = it.name
                }
            }

            componentScope.launch {
                users.value = service.getStaffList().toList()
                users.value.forEach {
                    if (it.id == userId.value) userName.value = it.fullName
                }
            }
        }
    }
}