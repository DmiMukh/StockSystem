package ru.hackathone.stocksystem.product.list

import com.arkivanov.decompose.ComponentContext

class RealProductListComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext,  ProductListComponent {

}