package ru.hackathone.core.inventoryApi.product.serviceImpl

import ru.hackathone.core.inventoryApi.product.client.ProductCategoryClientImpl
import ru.hackathone.core.inventoryApi.product.client.ProductClientImpl
import ru.hackathone.core.inventoryApi.product.client.ProductLocationClientImpl
import ru.hackathone.core.inventoryApi.product.client.ProductStatusClientImpl

class ProductUnionServiceImpl {
    val productService = ProductServiceImpl(ProductClientImpl())
    val categoryService = ProductCategoryServiceImpl(ProductCategoryClientImpl())
    val locationService = ProductLocationServiceImpl(ProductLocationClientImpl())
    val statusService = ProductStatusServiceImpl(ProductStatusClientImpl())
}