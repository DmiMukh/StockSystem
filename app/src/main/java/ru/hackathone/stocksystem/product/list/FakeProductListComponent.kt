package ru.hackathone.stocksystem.product.list

import ru.hackathone.stocksystem.product.list.toolbar.FakeProductListToolbarComponent

class FakeProductListComponent: ProductListComponent {
    override val toolbarComponent = FakeProductListToolbarComponent()
}