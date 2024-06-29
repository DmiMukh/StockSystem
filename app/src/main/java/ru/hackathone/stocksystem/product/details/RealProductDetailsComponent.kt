package ru.hackathone.stocksystem.product.details

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.hackathone.core.inventoryApi.product.dto.ProductRequest
import ru.hackathone.core.inventoryApi.product.models.Product
import ru.hackathone.core.inventoryApi.product.models.ProductCategory
import ru.hackathone.core.inventoryApi.product.models.ProductLocation
import ru.hackathone.core.inventoryApi.product.models.ProductStatus
import ru.hackathone.core.inventoryApi.product.service.ProductService
import ru.hackathone.core.message.data.MessageService
import ru.hackathone.core.message.domain.Message
import ru.hackathone.core.utils.componentScope
import ru.hackathone.stocksystem.product.details.toolbar.RealProductDetailsToolbarComponent

class RealProductDetailsComponent(
    componentContext: ComponentContext,
    private val product: Product,
    private val onBack: () -> Unit,
    private val service: ProductService,
    private val messageService: MessageService
) : ComponentContext by componentContext, ProductDetailsComponent {

    private val componentInstance = instanceKeeper.getOrCreate(RealProductDetailsComponent::ProductKeeper)

    override val toolbarComponent = RealProductDetailsToolbarComponent(
        componentContext = componentContext,
        onBack = { onBack.invoke() },
        onSave = {

            val newProduct = ProductRequest(
                name = name.value,
                quantity = 0,
                description = description.value,
                category = categoryId.value,
                location = locationId.value,
                status = statusId.value
            )

            componentScope.launch {
                if (product.id == -1) {
                    val productId = service.createProduct(newProduct)

                    messageService.showMessage(Message(text = "Product created! (ID = $productId)"))
                } else {
                    service.updateProduct(product.id, newProduct)
                    messageService.showMessage(Message(text = "Product updated!"))
                }

                onBack.invoke()
            }

            onBack.invoke()
        }
    )
    override val name get() = componentInstance.name
    override val description get() = componentInstance.description
    override val categoryId get() = componentInstance.categoryId
    override val categoryName get() = componentInstance.categoryName
    override val locationId get() = componentInstance.locationId
    override val locationRow get() = componentInstance.locationRow
    override val locationPlace get() = componentInstance.locationPlace
    override val statusId get() = componentInstance.statusId
    override val statusName get() = componentInstance.statusName
    override fun onCategoryChange(newValue: ProductCategory) {
        categoryId.value = newValue.id
        categoryName.value = newValue.name
    }

    override fun onDescriptionChange(newValue: String) {
        this.description.value = newValue
    }

    override fun onLocationChange(newValue: ProductLocation) {
        locationId.value = newValue.id
        locationRow.value = newValue.row
        locationPlace.value = newValue.place
    }

    override fun onNameChange(newValue: String) {
        this.name.value = newValue
    }

    override fun onStatusChange(newValue: ProductStatus) {
        statusId.value = newValue.id
        statusName.value = newValue.name
    }

    private class ProductKeeper :  InstanceKeeper.Instance {

        val isInit = false

        val name = MutableStateFlow("")
        val description = MutableStateFlow("")
        val categoryId = MutableStateFlow(0)
        val categoryName = MutableStateFlow("")
        val locationId = MutableStateFlow(0)
        val locationRow = MutableStateFlow("")
        val locationPlace = MutableStateFlow("")
        val statusId = MutableStateFlow(0)
        val statusName = MutableStateFlow("")

        override fun onDestroy() = Unit
    }

    init {
        if(!componentInstance.isInit) {
            this.name.value = this.product.name
            this.description.value = this.product.description
            this.categoryId.value = this.product.category.id
            this.categoryName.value = this.product.category.name
            this.locationId.value = this.product.location.id
            this.locationRow.value = this.product.location.row
            this.locationPlace.value = this.product.location.place
            this.statusId.value = this.product.status.id
            this.statusName.value = this.product.status.name
        }
    }
}