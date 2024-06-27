package ru.hackathone.stocksystem.product

import com.arkivanov.decompose.ComponentContext
import ru.hackathone.core.ComponentFactory
import ru.hackathone.stocksystem.product.details.ProductDetailsComponent
import ru.hackathone.stocksystem.product.details.RealProductDetailsComponent
import ru.hackathone.stocksystem.product.list.ProductListComponent
import ru.hackathone.stocksystem.product.list.RealProductListComponent

fun ComponentFactory.createProductList(
    componentContext: ComponentContext,
    onBack: () -> Unit
) : ProductListComponent {
    return RealProductListComponent(
        componentContext = componentContext,
        onBack = onBack
    )
}

fun ComponentFactory.createProductDetails(
    componentContext: ComponentContext,
    onBack: () -> Unit
) : ProductDetailsComponent {
    return RealProductDetailsComponent(
        componentContext = componentContext,
        onBack = onBack
    )
}