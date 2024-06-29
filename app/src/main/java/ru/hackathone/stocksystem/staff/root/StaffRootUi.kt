package ru.hackathone.stocksystem.staff.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import ru.hackathone.stocksystem.staff.list.StaffListUi

@Composable
fun StaffRootUi(
    component: StaffRootComponent,
    modifier: Modifier = Modifier
){
    val childStack = component.childStack.collectAsState()

    Children(
        stack = childStack.value,
        modifier = modifier,
        animation = stackAnimation(fade() + scale()),
    ) {
        when (val child = it.instance) {
            is StaffRootComponent.Child.List -> StaffListUi(child.component)
        }
    }
}