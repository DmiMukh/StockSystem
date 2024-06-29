package ru.hackathone.stocksystem.staff.list

import ru.hackathone.core.inventoryApi.staff.models.Staff

sealed class StaffListState {

    data class Display(val items: List<Staff>) : StaffListState()
    object Idle: StaffListState()
    object Loading: StaffListState()
    object NoItems: StaffListState()
}