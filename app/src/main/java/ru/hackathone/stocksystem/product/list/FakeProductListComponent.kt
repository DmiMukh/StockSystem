package ru.hackathone.stocksystem.product.list

import ru.hackathone.core.inventoryApi.product.models.Product
import ru.hackathone.stocksystem.product.list.toolbar.FakeProductListToolbarComponent

class FakeProductListComponent: ProductListComponent {
    override val toolbarComponent = FakeProductListToolbarComponent()
    override fun onAddProductClick() = Unit

    override fun onProductClick(product: Product) = Unit
}