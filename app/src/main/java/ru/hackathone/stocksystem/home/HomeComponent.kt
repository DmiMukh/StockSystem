package ru.hackathone.stocksystem.home

import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.stocksystem.home.toolbar.HomeToolbarComponent

interface HomeComponent {

    val toolbarComponent: HomeToolbarComponent

    val roleId: StateFlow<Int>

    fun onOrderClick()
    fun onProductClick()
    fun onStaffClick()

}