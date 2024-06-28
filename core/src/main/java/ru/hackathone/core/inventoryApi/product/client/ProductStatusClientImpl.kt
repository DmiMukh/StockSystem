package ru.hackathone.core.inventoryApi.product.client

import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.provideKtorHttpClient

class ProductStatusClientImpl(
    private val client: HttpClient = provideKtorHttpClient(),
    private val addr: String = "http://localhost"
) : ProductStatusClient {
    override suspend fun getProductStatusList(): HttpResponse {
        TODO("Not yet implemented")
    }
}