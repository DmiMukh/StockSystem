package ru.hackathone.core.inventoryApi.product.clientsInterfaces

import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.product.dto.Status

interface StatusClient {

    suspend fun create(status: Status): HttpResponse
    suspend fun update(id: Int, status: Status): HttpResponse
    suspend fun delete(id: Int): HttpResponse

    suspend fun getAll(): HttpResponse
    suspend fun getByName(name: String): HttpResponse

}