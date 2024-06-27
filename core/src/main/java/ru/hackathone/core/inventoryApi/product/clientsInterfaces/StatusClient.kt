package ru.hackathone.core.inventoryApi.product.clientsInterfaces

import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.product.models.ProductStatus

interface StatusClient {

    suspend fun create(status: ProductStatus): HttpResponse
    suspend fun update(id: Int, status: ProductStatus): HttpResponse
    suspend fun delete(id: Int): HttpResponse

    suspend fun getAll(): HttpResponse
    suspend fun getByName(name: String): HttpResponse

}