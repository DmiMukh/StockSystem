package ru.hackathone.core.inventoryApi.product.service

import ru.hackathone.core.inventoryApi.product.dto.ProductLocationRequest
import ru.hackathone.core.inventoryApi.product.models.ProductLocation

interface ProductLocationService {
    suspend fun createProductLocation(location: ProductLocationRequest): Int
    suspend fun updateProductLocation(locationId: Int, location: ProductLocationRequest)
    suspend fun deleteProductLocation(locationId: Int)

    suspend fun getProductLocationByRowAndPlace(location: ProductLocationRequest): ProductLocation
    suspend fun getProductLocationById(locationId: Int): ProductLocation

    suspend fun getProductLocationList(): Array<ProductLocation>
    suspend fun getProductLocationListByRow(row: String): Array<ProductLocation>
}