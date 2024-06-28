package ru.hackathone.core.inventoryApi.product.client

import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.product.dto.ProductLocationRequest
import ru.hackathone.core.provideKtorHttpClient

class ProductLocationClientImpl(
    private val client: HttpClient = provideKtorHttpClient(),
    private val addr: String = "http://localhost"
) : ProductLocationClient {
    override suspend fun createProductLocation(location: ProductLocationRequest): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun updateProductLocation(
        locationId: Int,
        location: ProductLocationRequest
    ): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProductLocation(locationId: Int): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getProductLocationList(): HttpResponse {
        TODO("Not yet implemented")
    }
}