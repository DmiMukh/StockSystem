package ru.hackathone.stocksystem.home

import com.arkivanov.decompose.ComponentContext
import ru.hackathone.stocksystem.home.toolbar.RealHomeToolbarComponent

class RealHomeComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext, HomeComponent {

    override val toolbarComponent = RealHomeToolbarComponent(
        componentContext = componentContext
    )
}