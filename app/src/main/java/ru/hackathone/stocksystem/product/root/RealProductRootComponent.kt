package ru.hackathone.stocksystem.product.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.essenty.parcelable.Parcelable
import kotlinx.coroutines.flow.StateFlow
import kotlinx.parcelize.Parcelize
import ru.hackathone.core.ComponentFactory
import ru.hackathone.core.utils.toStateFlow
import ru.hackathone.stocksystem.product.createProductDetailsComponent
import ru.hackathone.stocksystem.product.createProductListComponent

class RealProductRootComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val componentFactory: ComponentFactory
) : ComponentContext by componentContext, ProductRootComponent {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack: StateFlow<ChildStack<*, ProductRootComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.List,
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    private fun createChild(
        config: ChildConfig,
        componentContext: ComponentContext
    ): ProductRootComponent.Child = when (config) {
        is ChildConfig.Details -> ProductRootComponent.Child.Details(
            component = this.componentFactory.createProductDetailsComponent(
                componentContext = componentContext,
                onBack = { navigation.pop() }
            )
        )

        is ChildConfig.List -> ProductRootComponent.Child.List(
            component = this.componentFactory.createProductListComponent(
                componentContext = componentContext,
                onBack = this.onBack
            )
        )
    }

    sealed interface ChildConfig : Parcelable {
        @Parcelize
        object Details : ChildConfig

        @Parcelize
        object List : ChildConfig
    }
}