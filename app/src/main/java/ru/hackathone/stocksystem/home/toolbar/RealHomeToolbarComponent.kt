package ru.hackathone.stocksystem.home.toolbar

import com.arkivanov.decompose.ComponentContext

class RealHomeToolbarComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext, HomeToolbarComponent {
}