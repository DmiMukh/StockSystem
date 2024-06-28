package ru.hackathone.stocksystem.product.list

import com.arkivanov.decompose.ComponentContext
import ru.hackathone.core.inventoryApi.product.models.Product
import ru.hackathone.stocksystem.product.list.toolbar.RealProductListToolbarComponent

class RealProductListComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val onDetails: (Product) -> Unit
) : ComponentContext by componentContext,  ProductListComponent {

    override val toolbarComponent = RealProductListToolbarComponent(
        componentContext = componentContext,
        onBack = { onBack.invoke() }
    )

    override fun onAddProductClick() {
        onDetails.invoke(Product(id = -1, name = "New Product"))
    }

    override fun onProductClick(product: Product) = onDetails.invoke(product)
}