package ru.hackathone.stocksystem.staff.root

import com.arkivanov.decompose.router.stack.ChildStack
import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.stocksystem.staff.list.StaffListComponent

interface StaffRootComponent{
    val childStack: StateFlow<ChildStack<*, StaffRootComponent.Child>>

    sealed interface Child {
        //class Details(val component: StaffDetailsComponent) : StaffRootComponent.Child
        class List(val component: StaffListComponent) : StaffRootComponent.Child
    }
}