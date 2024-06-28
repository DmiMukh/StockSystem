package ru.hackathone.core.inventoryApi.product.serviceImpl

import ru.hackathone.core.inventoryApi.product.service.ProductCategoryService
import ru.hackathone.core.inventoryApi.product.service.ProductLocationService
import ru.hackathone.core.inventoryApi.product.service.ProductService
import ru.hackathone.core.inventoryApi.product.service.ProductStatusService

class ProductUnionServiceImpl {
    val productService: ProductService = ProductServiceImpl()
    val categoryService: ProductCategoryService = ProductCategoryServiceImpl()
    val locationService: ProductLocationService = ProductLocationServiceImpl()
    val statusService: ProductStatusService = ProductStatusServiceImpl()
}