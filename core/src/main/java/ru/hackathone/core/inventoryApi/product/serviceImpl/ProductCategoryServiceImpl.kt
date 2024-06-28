package ru.hackathone.core.inventoryApi.product.serviceImpl

import ru.hackathone.core.inventoryApi.product.models.ProductCategory
import ru.hackathone.core.inventoryApi.product.service.ProductCategoryService

class ProductCategoryServiceImpl: ProductCategoryService {
    override suspend fun getProductCategoryList(): Array<ProductCategory> {
        TODO("Not yet implemented")
    }

    @Deprecated("Not implemented")
    override suspend fun getProductCategoryByName(categoryName: String): ProductCategory {
        TODO("Not yet implemented")
    }

    @Deprecated("Not implemented")
    override suspend fun getProductCategoryById(categoryId: Int): ProductCategory {
        TODO("Not yet implemented")
    }
}