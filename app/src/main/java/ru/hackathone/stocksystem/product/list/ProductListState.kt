package ru.hackathone.stocksystem.product.list

import ru.hackathone.core.inventoryApi.product.models.Product

sealed class ProductListState {
    data class Display(val items: List<Product>) : ProductListState()
    object Idle: ProductListState()
    object Loading: ProductListState()
    object NoItems: ProductListState()
}