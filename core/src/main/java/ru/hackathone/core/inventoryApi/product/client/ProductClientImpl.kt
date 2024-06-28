package ru.hackathone.core.inventoryApi.product.client

import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.product.dto.ProductRequest
import ru.hackathone.core.provideKtorHttpClient

class ProductClientImpl(
    private val client: HttpClient = provideKtorHttpClient(),
    val addr: String = "http://localhost:8090"
) : ProductClient {
    override suspend fun createProduct(product: ProductRequest): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun updateProduct(productId: Int, product: ProductRequest): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProduct(productId: Int): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getProductList(): HttpResponse {
        TODO("Not yet implemented")
    }

}