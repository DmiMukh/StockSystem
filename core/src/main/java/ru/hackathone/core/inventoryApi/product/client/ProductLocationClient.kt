package ru.hackathone.core.inventoryApi.product.client

import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.product.dto.ProductLocationRequest

interface ProductLocationClient {
    suspend fun createProductLocation(location: ProductLocationRequest): HttpResponse
    suspend fun updateProductLocation(
        locationId: Int,
        location: ProductLocationRequest
    ): HttpResponse

    suspend fun deleteProductLocation(locationId: Int): HttpResponse
    suspend fun getProductLocationList(): HttpResponse
}