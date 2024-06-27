package ru.hackathone.stocksystem.product.list.toolbar

import com.arkivanov.decompose.ComponentContext

class RealProductListToolbarComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext, ProductListToolbarComponent {
}