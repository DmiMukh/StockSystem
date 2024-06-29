package ru.hackathone.stocksystem.staff

import com.arkivanov.decompose.ComponentContext
import org.koin.core.component.get
import ru.hackathone.core.ComponentFactory
import ru.hackathone.stocksystem.staff.list.RealStaffListComponent
import ru.hackathone.stocksystem.staff.list.StaffListComponent
import ru.hackathone.stocksystem.staff.root.RealStaffRootComponent
import ru.hackathone.stocksystem.staff.root.StaffRootComponent

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
    onDetails: () -> Unit
) : StaffListComponent {
    return RealStaffListComponent(
        componentContext = componentContext,
        onBack = onBack,
        onDetails = onDetails,
        service = get(),
        messageService = get(),
        storage = get()
    )
}