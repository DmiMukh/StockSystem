package ru.hackathone.stocksystem.staff.list

import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.stocksystem.staff.list.toolbar.StaffListToolbarComponent

interface StaffListComponent {

    val toolbarComponent: StaffListToolbarComponent


    val viewState: StateFlow<StaffListState>

    fun onAddStaffClick()
}