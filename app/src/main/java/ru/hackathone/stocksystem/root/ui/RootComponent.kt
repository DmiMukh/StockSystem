package ru.hackathone.stocksystem.root.ui

import com.arkivanov.decompose.router.stack.ChildStack
import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.core.message.ui.MessageComponent
import ru.hackathone.stocksystem.home.HomeComponent
import ru.hackathone.stocksystem.splash.SplashComponent

interface RootComponent {

    val childStack: StateFlow<ChildStack<*, Child>>

    val messageComponent: MessageComponent

    sealed interface Child {

        class Home(val component: HomeComponent) : Child
        class Splash(val component: SplashComponent) : Child
    }
}