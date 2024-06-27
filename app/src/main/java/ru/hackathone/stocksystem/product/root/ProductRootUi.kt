package ru.hackathone.stocksystem.product.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import ru.hackathone.stocksystem.product.details.ProductDetailsUi
import ru.hackathone.stocksystem.product.list.ProductListUi

@Composable
fun ProductRootUi(
    component: ProductRootComponent,
    modifier: Modifier = Modifier
) {
    val childStack = component.childStack.collectAsState()

    Children(
        stack = childStack.value,
        modifier = modifier,
        animation = stackAnimation(fade() + scale()),
    ) {
        when (val child = it.instance) {
            is ProductRootComponent.Child.Details -> ProductDetailsUi(child.component)
            is ProductRootComponent.Child.List -> ProductListUi(child.component)
        }
    }
}