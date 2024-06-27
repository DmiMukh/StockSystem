package ru.hackathone.stocksystem.product.details

import com.arkivanov.decompose.ComponentContext

class RealProductDetailsComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext, ProductDetailsComponent {
}