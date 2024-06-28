package ru.hackathone.stocksystem.product.details

import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.core.inventoryApi.product.models.ProductCategory
import ru.hackathone.core.inventoryApi.product.models.ProductLocation
import ru.hackathone.core.inventoryApi.product.models.ProductStatus
import ru.hackathone.stocksystem.product.details.toolbar.ProductDetailsToolbarComponent

interface ProductDetailsComponent {

    val toolbarComponent: ProductDetailsToolbarComponent
    val name: StateFlow<String>
    val description: StateFlow<String>
    val category: StateFlow<ProductCategory>
    val location: StateFlow<ProductLocation>
    val status: StateFlow<ProductStatus>
    fun onCategoryChange(newValue: ProductCategory)
    fun onDescriptionChange(newValue: String)
    fun onLocationChange(newValue: ProductLocation)
    fun onNameChange(newValue: String)
    fun onStatusChange(newValue: ProductStatus)
}