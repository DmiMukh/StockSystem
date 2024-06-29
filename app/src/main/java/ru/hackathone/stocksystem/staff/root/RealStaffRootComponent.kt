package ru.hackathone.stocksystem.staff.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.essenty.parcelable.Parcelable
import kotlinx.coroutines.flow.StateFlow
import kotlinx.parcelize.Parcelize
import ru.hackathone.core.ComponentFactory
import ru.hackathone.core.utils.toStateFlow
import ru.hackathone.stocksystem.staff.createStaffListComponent

class RealStaffRootComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val componentFactory: ComponentFactory
) : ComponentContext by componentContext, StaffRootComponent {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack: StateFlow<ChildStack<*, StaffRootComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.List,
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    private fun createChild(
        config: ChildConfig,
        componentContext: ComponentContext
    ): StaffRootComponent.Child = when (config) {
        is ChildConfig.List -> StaffRootComponent.Child.List(
            component = this.componentFactory.createStaffListComponent(
                componentContext = componentContext,
                onBack = { onBack.invoke() },
                onDetails = { }
            )
        )
    }

    sealed interface ChildConfig : Parcelable {
        @Parcelize
        object List : ChildConfig
    }
}