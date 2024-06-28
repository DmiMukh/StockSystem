package ru.hackathone.core.inventoryApi.product.client

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.provideKtorHttpClient

class ProductCategoryClientImpl(
    private val client: HttpClient = provideKtorHttpClient(),
    private val addr: String = "http://localhost"
) : ProductCategoryClient {
    override suspend fun getProductCategoryList(): HttpResponse {
        return client.get("$addr/product/category")
    }
}