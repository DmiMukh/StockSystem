package ru.hackathone.core.inventoryApi.product.service

import ru.hackathone.core.inventoryApi.product.models.ProductStatus

interface ProductStatusService {
    suspend fun getProductStatusList(): Array<ProductStatus>
    suspend fun getProductStatusById(): ProductStatus
    suspend fun getProductStatusByName(statusName: String): ProductStatus
}