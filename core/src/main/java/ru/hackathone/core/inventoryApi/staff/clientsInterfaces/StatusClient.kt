package ru.hackathone.core.inventoryApi.staff.clientsInterfaces

import ru.hackathone.core.inventoryApi.staff.dto.Status

interface StatusClient {

    suspend fun create(status: Status)
    suspend fun update(id: Int, status: Status)
    suspend fun delete(id: Int)

    suspend fun getAll()
    suspend fun getByName(name: String)

}