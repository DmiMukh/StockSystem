package ru.hackathone.stocksystem.product.details

import ru.hackathone.stocksystem.product.details.toolbar.FakeProductDetailsToolbarComponent

class FakeProductDetailsComponent: ProductDetailsComponent {
    override val toolbarComponent = FakeProductDetailsToolbarComponent()
}