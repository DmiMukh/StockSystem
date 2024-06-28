package ru.hackathone.core.inventoryApi.product.service

import ru.hackathone.core.inventoryApi.product.models.ProductCategory

interface ProductCategoryService {
    suspend fun getProductCategoryList(): Array<ProductCategory>
    suspend fun getProductCategoryByName(categoryName: String): ProductCategory
    suspend fun getProductCategoryById(categoryId:Int): ProductCategory
}