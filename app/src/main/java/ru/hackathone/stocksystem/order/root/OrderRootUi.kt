package ru.hackathone.stocksystem.order.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import ru.hackathone.stocksystem.order.details.OrderDetailsUi
import ru.hackathone.stocksystem.order.list.OrderListUi

@Composable
fun OrderRootUi(
    component: OrderRootComponent,
    modifier: Modifier = Modifier
){
    val childStack = component.childStack.collectAsState()

    Children(
        stack = childStack.value,
        modifier = modifier,
        animation = stackAnimation(fade() + scale()),
    ) {
        when (val child = it.instance) {
            is OrderRootComponent.Child.Details -> OrderDetailsUi(child.component)
            is OrderRootComponent.Child.List -> OrderListUi(child.component)
        }
    }
}