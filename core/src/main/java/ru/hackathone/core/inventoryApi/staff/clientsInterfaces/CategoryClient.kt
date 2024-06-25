package ru.hackathone.core.inventoryApi.staff.clientsInterfaces

import ru.hackathone.core.inventoryApi.staff.dto.Category

interface CategoryClient {
    suspend fun create(category: Category)
    suspend fun update(id: Int, category: Category)
    suspend fun delete(id: Int)

    suspend fun getAll()
    suspend fun getById(id: Int)
    suspend fun getByName(name: String)
}