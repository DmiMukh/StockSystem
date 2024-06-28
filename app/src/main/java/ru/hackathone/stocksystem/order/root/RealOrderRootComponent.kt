package ru.hackathone.stocksystem.order.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.essenty.parcelable.Parcelable
import kotlinx.coroutines.flow.StateFlow
import kotlinx.parcelize.Parcelize
import ru.hackathone.core.ComponentFactory
import ru.hackathone.core.inventoryApi.staff.models.Task
import ru.hackathone.core.utils.toStateFlow
import ru.hackathone.stocksystem.order.createOrderDetailsComponent
import ru.hackathone.stocksystem.order.createOrderListComponent

class RealOrderRootComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val componentFactory: ComponentFactory
) : ComponentContext by componentContext, OrderRootComponent {
    private val navigation = StackNavigation<RealOrderRootComponent.ChildConfig>()

    override val childStack: StateFlow<ChildStack<*, OrderRootComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = RealOrderRootComponent.ChildConfig.List,
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    private fun createChild(
        config: RealOrderRootComponent.ChildConfig,
        componentContext: ComponentContext
    ): OrderRootComponent.Child = when (config) {
        is ChildConfig.Details -> OrderRootComponent.Child.Details(
            component = this.componentFactory.createOrderDetailsComponent(
                componentContext = componentContext,
                task = config.task,
                onBack = { navigation.pop() }
            )
        )
        is ChildConfig.List -> OrderRootComponent.Child.List(
            component = this.componentFactory.createOrderListComponent(
                componentContext = componentContext,
                onBack = { onBack.invoke() }
            )
        )
    }

    sealed interface ChildConfig : Parcelable {
        @Parcelize
        class Details(val task: Task) : ChildConfig

        @Parcelize
        object List : ChildConfig
    }
}