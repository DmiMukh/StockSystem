package ru.hackathone.stocksystem.home

import ru.hackathone.stocksystem.home.toolbar.HomeToolbarComponent

interface HomeComponent {

    val toolbarComponent: HomeToolbarComponent

    fun onProductClick()
    fun onStaffClick()

}