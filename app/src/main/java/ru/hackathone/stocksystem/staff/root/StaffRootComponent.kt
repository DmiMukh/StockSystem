package ru.hackathone.stocksystem.staff.root

import com.arkivanov.decompose.router.stack.ChildStack
import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.stocksystem.staff.list.StaffListComponent
import ru.hackathone.stocksystem.staff.signup.SignUpComponent

interface StaffRootComponent{
    val childStack: StateFlow<ChildStack<*, Child>>

    sealed interface Child {
        //class Details(val component: StaffDetailsComponent) : Child
        class List(val component: StaffListComponent) : Child
        class SignUp(val component: SignUpComponent) : Child
    }
}