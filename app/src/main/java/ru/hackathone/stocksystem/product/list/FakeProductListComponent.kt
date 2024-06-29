package ru.hackathone.stocksystem.product.list

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.core.inventoryApi.product.models.Product
import ru.hackathone.stocksystem.product.list.toolbar.FakeProductListToolbarComponent

class FakeProductListComponent: ProductListComponent {
    override val toolbarComponent = FakeProductListToolbarComponent()
    override val viewState = MutableStateFlow<ProductListState>(ProductListState.Idle)

    override fun onAddProductClick() = Unit

    override fun onProductClick(product: Product) = Unit
}