package ru.hackathone.stocksystem.root.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import ru.hackathone.core.message.ui.MessageUi
import ru.hackathone.stocksystem.home.HomeUi
import ru.hackathone.stocksystem.product.root.ProductRootUi
import ru.hackathone.stocksystem.settings.SettingsUi
import ru.hackathone.stocksystem.signin.SignInUi
import ru.hackathone.stocksystem.splash.SplashUi

@Composable
fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier
) {
    val childStack = component.childStack.collectAsState()

    Children(
        stack = childStack.value,
        modifier = modifier,
        animation = stackAnimation(fade() + scale()),
    ) {
        when (val child = it.instance) {
            is RootComponent.Child.Home -> HomeUi(child.component)
            is RootComponent.Child.ProductRoot -> ProductRootUi(child.component)
            is RootComponent.Child.Settings -> SettingsUi(child.component)
            is RootComponent.Child.SignIn -> SignInUi(child.component)
            is RootComponent.Child.Splash -> SplashUi(child.component)
        }
    }

    MessageUi(
        component = component.messageComponent,
        modifier = modifier,
        bottomPadding = 16.dp
    )
}