package ru.hackathone.stocksystem.product.details

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.core.inventoryApi.product.models.ProductCategory
import ru.hackathone.core.inventoryApi.product.models.ProductLocation
import ru.hackathone.core.inventoryApi.product.models.ProductStatus
import ru.hackathone.stocksystem.product.details.toolbar.FakeProductDetailsToolbarComponent

class FakeProductDetailsComponent: ProductDetailsComponent {
    override val toolbarComponent = FakeProductDetailsToolbarComponent()
    override val name = MutableStateFlow("")
    override val description = MutableStateFlow("")
    override val categoryId = MutableStateFlow(0)
    override val categoryName = MutableStateFlow("")
    override val locationId = MutableStateFlow(0)
    override val locationRow = MutableStateFlow("")
    override val locationPlace = MutableStateFlow("")
    override val statusId = MutableStateFlow(0)
    override val statusName = MutableStateFlow("")
    override val categories = MutableStateFlow<List<ProductCategory>>(emptyList())
    override val locations = MutableStateFlow<List<ProductLocation>>(emptyList())
    override val statuses = MutableStateFlow<List<ProductStatus>>(emptyList())
    override fun onCategoryChange(newValue: ProductCategory) = Unit

    override fun onDescriptionChange(newValue: String) = Unit

    override fun onLocationChange(newValue: ProductLocation) = Unit

    override fun onNameChange(newValue: String) = Unit

    override fun onStatusChange(newValue: ProductStatus) = Unit
}