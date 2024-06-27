package ru.hackathone.core.inventoryApi.product.clientsInterfaces

import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.product.models.ProductLocation

interface LocationClient {
    suspend fun create(location: ProductLocation): HttpResponse
    suspend fun update(id: Int, location: ProductLocation): HttpResponse
    suspend fun delete(id: Int): HttpResponse

    suspend fun getAll(): HttpResponse
    suspend fun getById(id: Int): HttpResponse
    suspend fun getByRow(row: String): HttpResponse
}