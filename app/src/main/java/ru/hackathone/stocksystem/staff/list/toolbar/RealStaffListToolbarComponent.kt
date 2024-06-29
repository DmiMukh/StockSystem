package ru.hackathone.stocksystem.staff.list.toolbar

import com.arkivanov.decompose.ComponentContext

class RealStaffListToolbarComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val onRefresh: () -> Unit
) : ComponentContext by componentContext, StaffListToolbarComponent {
    override fun onBackClick() = this.onBack.invoke()
    override fun onRefreshClick() = this.onRefresh.invoke()
}