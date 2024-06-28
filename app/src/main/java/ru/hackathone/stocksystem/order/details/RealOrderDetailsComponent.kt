package ru.hackathone.stocksystem.order.details

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.flow.MutableStateFlow
import ru.hackathone.core.inventoryApi.staff.models.Task
import ru.hackathone.stocksystem.order.details.toolbar.RealOrderDetailsToolbarComponent

class RealOrderDetailsComponent(
    componentContext: ComponentContext,
    private val task: Task,
    private val onBack: () -> Unit
) : ComponentContext by componentContext, OrderDetailsComponent {

    private val componentInstance = instanceKeeper.getOrCreate(RealOrderDetailsComponent::TaskKeeper)

    override val toolbarComponent = RealOrderDetailsToolbarComponent(
        componentContext = componentContext,
        onBack = this.onBack
    )
    override val description get() = componentInstance.description
    override val title get() = componentInstance.title

    private class TaskKeeper :  InstanceKeeper.Instance {

        val isInit = false

        val title = MutableStateFlow("")
        val description = MutableStateFlow("")

        override fun onDestroy() = Unit
    }

    init {
        if(!componentInstance.isInit) {
            this.title.value = this.task.title
            this.description.value = this.task.description
        }
    }
}