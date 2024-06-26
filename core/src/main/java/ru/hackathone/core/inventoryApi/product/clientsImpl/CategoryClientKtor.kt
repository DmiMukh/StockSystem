package ru.hackathone.core.inventoryApi.product.clientsImpl

import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse
import ru.hackathone.core.inventoryApi.product.clientsInterfaces.CategoryClient
import ru.hackathone.core.inventoryApi.product.dto.Category

class CategoryClientKtor(private val client: HttpClient) : CategoryClient {
    val addr = "http://localhost:8090"

    override suspend fun create(category: Category): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun update(id: Int, category: Category): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: Int): HttpResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getByName(name: String): HttpResponse {
        TODO("Not yet implemented")
    }
}