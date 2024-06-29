package ru.hackathone.stocksystem

import com.arkivanov.decompose.ComponentContext
import ru.hackathone.core.ComponentFactory
import ru.hackathone.core.coreModule
import ru.hackathone.stocksystem.home.HomeComponent
import ru.hackathone.stocksystem.home.RealHomeComponent
import ru.hackathone.stocksystem.settings.RealSettingsComponent
import ru.hackathone.stocksystem.settings.SettingsComponent
import ru.hackathone.stocksystem.signin.RealSignInComponent
import ru.hackathone.stocksystem.signin.SignInComponent
import ru.hackathone.stocksystem.splash.RealSplashComponent
import ru.hackathone.stocksystem.splash.SplashComponent
import org.koin.core.component.get

val allModules = listOf(
    coreModule
)

fun ComponentFactory.createHomeComponent(
    componentContext: ComponentContext,
    onOrder: () -> Unit,
    onProduct: () -> Unit,
    onStaff: () -> Unit,
    onLogOut: () -> Unit
): HomeComponent {
    return RealHomeComponent(
        componentContext = componentContext,
        onOrder = onOrder,
        onProduct = onProduct,
        onStaff = onStaff,
        onLogOut = onLogOut,
        storage = get()
    )
}

fun ComponentFactory.createSettingsComponent(
    componentContext: ComponentContext,
    onBack: () -> Unit
): SettingsComponent {
    return RealSettingsComponent(
        componentContext = componentContext,
        onBack = onBack,
        storage = get()
    )
}

fun ComponentFactory.createSignInComponent(
    componentContext: ComponentContext,
    onSettings: () -> Unit,
    onSignInComplete: () -> Unit
): SignInComponent {
    return RealSignInComponent(
        componentContext = componentContext,
        onSettings = onSettings,
        onSignInComplete = onSignInComplete,
        service = get(),
        messageService = get(),
        storage = get()
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