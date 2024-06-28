package ru.hackathone.core.inventoryApi.product.client

import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.product.dto.ProductRequest

interface ProductClient {
    suspend fun createProduct(product: ProductRequest): HttpResponse
    suspend fun updateProduct(productId: Int, product: ProductRequest): HttpResponse
    suspend fun deleteProduct(productId: Int): HttpResponse

    suspend fun getProductList(): HttpResponse
}