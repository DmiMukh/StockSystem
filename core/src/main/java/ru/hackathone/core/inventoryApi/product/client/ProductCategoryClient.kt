package ru.hackathone.core.inventoryApi.product.client

import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.product.models.ProductCategory

interface ProductCategoryClient {
    suspend fun getProductCategoryList(): HttpResponse
}