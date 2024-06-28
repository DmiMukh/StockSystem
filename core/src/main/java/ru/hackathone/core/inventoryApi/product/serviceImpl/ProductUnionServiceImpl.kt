package ru.hackathone.core.inventoryApi.product.serviceImpl

import ru.hackathone.core.inventoryApi.product.client.ProductCategoryClientImpl
import ru.hackathone.core.inventoryApi.product.client.ProductClientImpl
import ru.hackathone.core.inventoryApi.product.client.ProductLocationClientImpl
import ru.hackathone.core.inventoryApi.product.client.ProductStatusClientImpl
import ru.hackathone.core.inventoryApi.product.service.ProductCategoryService
import ru.hackathone.core.inventoryApi.product.service.ProductLocationService
import ru.hackathone.core.inventoryApi.product.service.ProductService
import ru.hackathone.core.inventoryApi.product.service.ProductStatusService

class ProductUnionServiceImpl {
    val productService: ProductService = ProductServiceImpl(ProductClientImpl())
    val categoryService: ProductCategoryService =
        ProductCategoryServiceImpl(ProductCategoryClientImpl())
    val locationService: ProductLocationService =
        ProductLocationServiceImpl(ProductLocationClientImpl())
    val statusService: ProductStatusService = ProductStatusServiceImpl(ProductStatusClientImpl())
}