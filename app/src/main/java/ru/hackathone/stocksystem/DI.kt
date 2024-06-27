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
    onProduct: () -> Unit,
    onStaff: () -> Unit
): HomeComponent {
    return RealHomeComponent(
        componentContext = componentContext,
        onProduct = onProduct,
        onStaff = onStaff
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
    onSignInComplete: () -> Unit
): SignInComponent {
    return RealSignInComponent(
        componentContext = componentContext,
        onSignInComplete = onSignInComplete
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