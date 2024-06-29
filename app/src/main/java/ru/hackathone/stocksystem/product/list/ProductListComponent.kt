package ru.hackathone.stocksystem.product.list

import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.core.inventoryApi.product.models.Product
import ru.hackathone.stocksystem.product.list.toolbar.ProductListToolbarComponent

interface ProductListComponent {

    val toolbarComponent: ProductListToolbarComponent

    val viewState: StateFlow<ProductListState>

    fun onAddProductClick()
    fun onProductClick(product: Product)
}