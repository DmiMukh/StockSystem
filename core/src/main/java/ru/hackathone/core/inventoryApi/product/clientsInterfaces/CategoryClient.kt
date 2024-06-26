package ru.hackathone.core.inventoryApi.product.clientsInterfaces

import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.product.dto.Category

interface CategoryClient {
    suspend fun create(category: Category) : HttpResponse
    suspend fun update(id: Int, category: Category) : HttpResponse
    suspend fun delete(id: Int) : HttpResponse

    suspend fun getAll() : HttpResponse
    suspend fun getById(id: Int) : HttpResponse
    suspend fun getByName(name: String) : HttpResponse
}