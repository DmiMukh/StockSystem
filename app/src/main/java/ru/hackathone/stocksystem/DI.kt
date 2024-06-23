package ru.hackathone.stocksystem

import com.arkivanov.decompose.ComponentContext
import ru.hackathone.core.ComponentFactory
import ru.hackathone.core.coreModule
import ru.hackathone.stocksystem.home.HomeComponent
import ru.hackathone.stocksystem.home.RealHomeComponent
import ru.hackathone.stocksystem.splash.RealSplashComponent
import ru.hackathone.stocksystem.splash.SplashComponent

val allModules = listOf(
    coreModule
)

fun ComponentFactory.createHomeComponent(
    componentContext: ComponentContext
): HomeComponent {
    return RealHomeComponent(
        componentContext = componentContext
    )
}

fun ComponentFactory.createSplashComponent(
    componentContext: ComponentContext,
    onFinish: () -> Unit
): SplashComponent {
    return RealSplashComponent(
        componentContext = componentContext,
        onFinish = onFinish
    )
}