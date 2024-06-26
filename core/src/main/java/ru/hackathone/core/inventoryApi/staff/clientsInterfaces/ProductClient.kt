package ru.hackathone.core.inventoryApi.staff.clientsInterfaces

import ru.hackathone.core.inventoryApi.staff.dto.Product

interface ProductClient {
    suspend fun create(product: Product)
    suspend fun update(id: Int, product: Product)
    suspend fun delete(id: Int)

    suspend fun getAll()
    suspend fun getById(id: Int)
    suspend fun getByName(name: String)
}