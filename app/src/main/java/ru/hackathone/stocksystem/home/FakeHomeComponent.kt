package ru.hackathone.stocksystem.home

import ru.hackathone.stocksystem.home.toolbar.FakeHomeToolbarComponent

class FakeHomeComponent : HomeComponent {

    override val toolbarComponent = FakeHomeToolbarComponent()
}