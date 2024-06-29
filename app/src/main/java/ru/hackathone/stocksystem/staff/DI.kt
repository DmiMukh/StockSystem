package ru.hackathone.stocksystem.staff

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.get
import ru.hackathone.core.ComponentFactory
import ru.hackathone.stocksystem.staff.list.RealStaffListComponent
import ru.hackathone.stocksystem.staff.list.StaffListComponent
import ru.hackathone.stocksystem.staff.root.RealStaffRootComponent
import ru.hackathone.stocksystem.staff.root.StaffRootComponent
import ru.hackathone.stocksystem.staff.signup.RealSignUpComponent
import ru.hackathone.stocksystem.staff.signup.SignUpComponent

fun ComponentFactory.createStaffRootComponent(
    componentContext: ComponentContext,
    onBack: () -> Unit
) : StaffRootComponent {
    return RealStaffRootComponent(
        componentContext = componentContext,
        onBack = onBack,
        componentFactory = get()
    )
}

fun ComponentFactory.createStaffListComponent(
    componentContext: ComponentContext,
    onBack: () -> Unit,
    onDetails: () -> Unit,
    onSignUp: () -> Unit
) : StaffListComponent {
    return RealStaffListComponent(
        componentContext = componentContext,
        onBack = onBack,
        onDetails = onDetails,
        onSignUp = onSignUp,
        service = get(),
        messageService = get(),
        storage = get()
    )
}

fun ComponentFactory.createRealSignUpComponent(
    componentContext: ComponentContext,
    onBack: () -> Unit
) : SignUpComponent {
    return RealSignUpComponent(
        componentContext = componentContext,
        onBack = onBack,
        authService = get(),
        staffService = get(),
        messageService = get()
    )
}