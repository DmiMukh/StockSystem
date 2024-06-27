package ru.hackathone.core.inventoryApi.product.clientsInterfaces

import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.product.models.ProductCategory

interface CategoryClient {
    suspend fun create(category: ProductCategory) : HttpResponse
    suspend fun update(id: Int, category: ProductCategory) : HttpResponse
    suspend fun delete(id: Int) : HttpResponse

    suspend fun getAll() : HttpResponse
    suspend fun getById(id: Int) : HttpResponse
    suspend fun getByName(name: String) : HttpResponse
}