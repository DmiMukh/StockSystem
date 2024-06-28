package ru.hackathone.stocksystem.product.details

import kotlinx.coroutines.flow.MutableStateFlow
import ru.hackathone.core.inventoryApi.product.models.ProductCategory
import ru.hackathone.core.inventoryApi.product.models.ProductLocation
import ru.hackathone.core.inventoryApi.product.models.ProductStatus
import ru.hackathone.stocksystem.product.details.toolbar.FakeProductDetailsToolbarComponent

class FakeProductDetailsComponent: ProductDetailsComponent {
    override val toolbarComponent = FakeProductDetailsToolbarComponent()
    override val name = MutableStateFlow("")
    override val description = MutableStateFlow("")
    override val category = MutableStateFlow(ProductCategory())
    override val location = MutableStateFlow(ProductLocation())
    override val status = MutableStateFlow(ProductStatus())

    override fun onCategoryChange(newValue: ProductCategory) = Unit

    override fun onDescriptionChange(newValue: String) = Unit

    override fun onLocationChange(newValue: ProductLocation) = Unit

    override fun onNameChange(newValue: String) = Unit

    override fun onStatusChange(newValue: ProductStatus) = Unit
}