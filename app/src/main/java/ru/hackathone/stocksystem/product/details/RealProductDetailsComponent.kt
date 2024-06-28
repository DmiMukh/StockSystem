package ru.hackathone.stocksystem.product.details

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.flow.MutableStateFlow
import ru.hackathone.core.inventoryApi.product.models.Product
import ru.hackathone.core.inventoryApi.product.models.ProductCategory
import ru.hackathone.core.inventoryApi.product.models.ProductLocation
import ru.hackathone.core.inventoryApi.product.models.ProductStatus
import ru.hackathone.stocksystem.product.details.toolbar.RealProductDetailsToolbarComponent

class RealProductDetailsComponent(
    componentContext: ComponentContext,
    private val product: Product,
    private val onBack: () -> Unit
) : ComponentContext by componentContext, ProductDetailsComponent {

    private val componentInstance = instanceKeeper.getOrCreate(RealProductDetailsComponent::ProductKeeper)

    override val toolbarComponent = RealProductDetailsToolbarComponent(
        componentContext = componentContext,
        onBack = { onBack.invoke() },
        onSave = {
            // TODO("Add Save")
            onBack.invoke()
        }
    )
    override val name get() = componentInstance.name
    override val description get() = componentInstance.description
    override val category get() = componentInstance.category
    override val location get() = componentInstance.location
    override val status get() = componentInstance.status
    override fun onCategoryChange(newValue: ProductCategory) {
        TODO("Not yet implemented")
    }

    override fun onDescriptionChange(newValue: String) {
        this.description.value = newValue
    }

    override fun onLocationChange(newValue: ProductLocation) {
        TODO("Not yet implemented")
    }

    override fun onNameChange(newValue: String) {
        this.name.value = newValue
    }

    override fun onStatusChange(newValue: ProductStatus) {
        TODO("Not yet implemented")
    }

    private class ProductKeeper :  InstanceKeeper.Instance {

        val isInit = false

        val name = MutableStateFlow("")
        val description = MutableStateFlow("")
        val category = MutableStateFlow(ProductCategory())
        val location = MutableStateFlow(ProductLocation())
        val status = MutableStateFlow(ProductStatus())

        override fun onDestroy() = Unit
    }

    init {
        if(!componentInstance.isInit) {
            this.name.value = this.product.name
            this.description.value = this.product.description
            this.category.value = this.product.category
            this.location.value = this.product.location
            this.status.value = this.product.status
        }
    }
}