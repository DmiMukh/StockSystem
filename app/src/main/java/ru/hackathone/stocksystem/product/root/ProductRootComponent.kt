package ru.hackathone.stocksystem.product.root

import com.arkivanov.decompose.router.stack.ChildStack
import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.stocksystem.product.details.ProductDetailsComponent
import ru.hackathone.stocksystem.product.list.ProductListComponent

interface ProductRootComponent {

    val childStack: StateFlow<ChildStack<*, Child>>

    sealed interface Child {

        class Details(val component: ProductDetailsComponent) : Child
        class List(val component: ProductListComponent) : Child
    }
}