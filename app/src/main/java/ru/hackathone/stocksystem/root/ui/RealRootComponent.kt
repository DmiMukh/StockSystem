package ru.hackathone.stocksystem.root.ui

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.essenty.parcelable.Parcelable
import kotlinx.coroutines.flow.StateFlow
import kotlinx.parcelize.Parcelize
import ru.hackathone.core.ComponentFactory
import ru.hackathone.core.createMessageComponent
import ru.hackathone.core.utils.toStateFlow
import ru.hackathone.stocksystem.createHomeComponent
import ru.hackathone.stocksystem.createSettingsComponent
import ru.hackathone.stocksystem.createSignInComponent
import ru.hackathone.stocksystem.createSplashComponent
import ru.hackathone.stocksystem.order.createOrderRootComponent
import ru.hackathone.stocksystem.product.createProductRootComponent

class RealRootComponent(
    componentContext: ComponentContext,
    private val componentFactory: ComponentFactory
) : ComponentContext by componentContext, RootComponent {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack: StateFlow<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.Splash,
        handleBackButton = true,
        childFactory = ::createChild
    ).toStateFlow(lifecycle)

    override val messageComponent = componentFactory.createMessageComponent(
        childContext(key = "message")
    )

    private fun createChild(
        config: ChildConfig,
        componentContext: ComponentContext
    ): RootComponent.Child = when (config) {

        ChildConfig.Home -> RootComponent.Child.Home(
            component = this.componentFactory.createHomeComponent(
                componentContext = componentContext,
                onOrder = { navigation.push(ChildConfig.OrderRoot) },
                onProduct = { navigation.push(ChildConfig.ProductRoot) },
                onStaff = {}
            )
        )

        ChildConfig.OrderRoot -> RootComponent.Child.OrderRoot(
            component = this.componentFactory.createOrderRootComponent(
                componentContext = componentContext,
                onBack = { navigation.pop() }
            )
        )

        ChildConfig.ProductRoot -> RootComponent.Child.ProductRoot(
            component = this.componentFactory.createProductRootComponent(
                componentContext = componentContext,
                onBack = { navigation.pop() }
            )
        )

        ChildConfig.Settings -> RootComponent.Child.Settings(
            component = this.componentFactory.createSettingsComponent(
                componentContext = componentContext,
                onBack = { navigation.pop() }
            )
        )

        ChildConfig.SignIn -> RootComponent.Child.SignIn(
            component = this.componentFactory.createSignInComponent(
                componentContext = componentContext,
                onSettings = { navigation.push(ChildConfig.Settings) },
                onSignInComplete = { navigation.replaceCurrent(ChildConfig.Home) }
            )
        )

        ChildConfig.Splash -> RootComponent.Child.Splash(
            component = this.componentFactory.createSplashComponent(
                componentContext = componentContext,
                onFinish = { navigation.replaceCurrent(ChildConfig.SignIn) }
            )
        )
    }

    private sealed interface ChildConfig : Parcelable {

        @Parcelize
        object Home : ChildConfig

        @Parcelize
        object OrderRoot : ChildConfig

        @Parcelize
        object ProductRoot : ChildConfig

        @Parcelize
        object Settings : ChildConfig

        @Parcelize
        object SignIn : ChildConfig

        @Parcelize
        object Splash : ChildConfig
    }
}