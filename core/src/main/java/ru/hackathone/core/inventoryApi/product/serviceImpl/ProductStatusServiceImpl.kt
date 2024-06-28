package ru.hackathone.core.inventoryApi.product.serviceImpl

import ru.hackathone.core.inventoryApi.product.client.ProductStatusClient
import ru.hackathone.core.inventoryApi.product.models.ProductStatus
import ru.hackathone.core.inventoryApi.product.service.ProductStatusService

class ProductStatusServiceImpl(private val client: ProductStatusClient) : ProductStatusService {
    override suspend fun getProductStatusList(): Array<ProductStatus> {
        TODO("Not yet implemented")
    }

    @Deprecated("Not implemented")
    override suspend fun getProductStatusById(): ProductStatus {
        TODO("Not yet implemented")
    }

    @Deprecated("Not implemented")
    override suspend fun getProductStatusByName(statusName: String): ProductStatus {
        TODO("Not yet implemented")
    }
}