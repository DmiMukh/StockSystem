package ru.hackathone.stocksystem.product

import com.arkivanov.decompose.ComponentContext
import ru.hackathone.core.ComponentFactory
import ru.hackathone.stocksystem.product.details.ProductDetailsComponent
import ru.hackathone.stocksystem.product.details.RealProductDetailsComponent
import ru.hackathone.stocksystem.product.list.ProductListComponent
import ru.hackathone.stocksystem.product.list.RealProductListComponent
import ru.hackathone.stocksystem.product.root.ProductRootComponent
import ru.hackathone.stocksystem.product.root.RealProductRootComponent
import org.koin.core.component.get
import ru.hackathone.core.inventoryApi.product.models.Product


fun ComponentFactory.createProductRootComponent(
    componentContext: ComponentContext,
    onBack: () -> Unit
) : ProductRootComponent {
    return RealProductRootComponent(
        componentContext = componentContext,
        onBack = onBack,
        componentFactory = get()
    )
}

fun ComponentFactory.createProductListComponent(
    componentContext: ComponentContext,
    onBack: () -> Unit,
    onDetails: (Product) -> Unit
) : ProductListComponent {
    return RealProductListComponent(
        componentContext = componentContext,
        onBack = onBack,
        onDetails = onDetails
    )
}

fun ComponentFactory.createProductDetailsComponent(
    componentContext: ComponentContext,
    oldProduct: Product,
    onBack: () -> Unit
) : ProductDetailsComponent {
    return RealProductDetailsComponent(
        componentContext = componentContext,
        oldProduct = oldProduct,
        onBack = onBack
    )
}