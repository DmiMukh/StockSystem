package ru.hackathone.core.inventoryApi.staff.clientsImpl

import ru.hackathone.core.inventoryApi.staff.clientsInterfaces.CategoryClient
import ru.hackathone.core.inventoryApi.staff.dto.Category

class CategoryClientKtor : CategoryClient {
    override suspend fun create(category: Category) {
        TODO("Not yet implemented")
    }

    override suspend fun update(id: Int, category: Category) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun getAll() {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun getByName(name: String) {
        TODO("Not yet implemented")
    }
}