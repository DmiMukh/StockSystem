package ru.hackathone.stocksystem.product.list

import ru.hackathone.core.inventoryApi.product.models.Product
import ru.hackathone.stocksystem.product.list.toolbar.ProductListToolbarComponent

interface ProductListComponent {

    val toolbarComponent: ProductListToolbarComponent


    fun onAddProductClick()
    fun onProductClick(product: Product)
}