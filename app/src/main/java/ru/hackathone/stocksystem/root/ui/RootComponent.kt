package ru.hackathone.stocksystem.root.ui

import com.arkivanov.decompose.router.stack.ChildStack
import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.core.message.ui.MessageComponent
import ru.hackathone.stocksystem.home.HomeComponent
import ru.hackathone.stocksystem.order.root.OrderRootComponent
import ru.hackathone.stocksystem.product.root.ProductRootComponent
import ru.hackathone.stocksystem.settings.SettingsComponent
import ru.hackathone.stocksystem.signin.SignInComponent
import ru.hackathone.stocksystem.splash.SplashComponent
import ru.hackathone.stocksystem.staff.root.StaffRootComponent

interface RootComponent {

    val childStack: StateFlow<ChildStack<*, Child>>

    val messageComponent: MessageComponent

    sealed interface Child {

        class Home(val component: HomeComponent) : Child
        class OrderRoot(val component: OrderRootComponent) : Child
        class ProductRoot(val component: ProductRootComponent) : Child
        class Settings(val component: SettingsComponent) : Child
        class SignIn(val component: SignInComponent) : Child
        class Splash(val component: SplashComponent) : Child

        class StaffRoot(val component: StaffRootComponent) : Child
    }
}