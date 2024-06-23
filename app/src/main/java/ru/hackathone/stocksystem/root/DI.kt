package ru.hackathone.stocksystem.root

import com.arkivanov.decompose.ComponentContext
import ru.hackathone.core.ComponentFactory
import ru.hackathone.stocksystem.root.ui.RealRootComponent
import ru.hackathone.stocksystem.root.ui.RootComponent
import org.koin.core.component.get

fun ComponentFactory.createRootComponent(componentContext: ComponentContext): RootComponent {
    return RealRootComponent(
        componentContext = componentContext,
        componentFactory = get()
    )
}