package ru.hackathone.core.inventoryApi.product.serviceImpl

import ru.hackathone.core.inventoryApi.product.client.ProductLocationClient
import ru.hackathone.core.inventoryApi.product.dto.ProductLocationRequest
import ru.hackathone.core.inventoryApi.product.models.ProductLocation
import ru.hackathone.core.inventoryApi.product.service.ProductLocationService

class ProductLocationServiceImpl(private val client: ProductLocationClient) :
    ProductLocationService {
    override suspend fun createProductLocation(location: ProductLocationRequest): Int {
        TODO("Not yet implemented")
    }

    override suspend fun updateProductLocation(locationId: Int, location: ProductLocationRequest) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProductLocation(locationId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun getProductLocationList(): Array<ProductLocation> {
        TODO("Not yet implemented")
    }


    @Deprecated("Not implemented")
    override suspend fun getProductLocationByRowAndPlace(location: ProductLocationRequest): ProductLocation {
        TODO("Not yet implemented")
    }

    @Deprecated("Not implemented")
    override suspend fun getProductLocationById(locationId: Int): ProductLocation {
        TODO("Not yet implemented")
    }


    @Deprecated("Not implemented")
    override suspend fun getProductLocationListByRow(row: String): Array<ProductLocation> {
        TODO("Not yet implemented")
    }
}