package ru.hackathone.core.inventoryApi.staff.clientsInterfaces

import ru.hackathone.core.inventoryApi.staff.dto.Location

interface LocationClient {
    suspend fun create(location: Location)
    suspend fun update(id: Int, location: Location)
    suspend fun delete(id: Int)

    suspend fun getAll()
    suspend fun getById(id: Int)
    suspend fun getByRow(row: String)
}