package ru.hackathone.core.inventoryApi.product.serviceImpl

import io.ktor.client.call.body
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import ru.hackathone.core.inventoryApi.exceptions.BadRequestException
import ru.hackathone.core.inventoryApi.exceptions.NoContentException
import ru.hackathone.core.inventoryApi.exceptions.UnknownStatusCodeException
import ru.hackathone.core.inventoryApi.product.client.ProductLocationClient
import ru.hackathone.core.inventoryApi.product.dto.ProductLocationRequest
import ru.hackathone.core.inventoryApi.product.models.ProductLocation
import ru.hackathone.core.inventoryApi.product.service.ProductLocationService

class ProductLocationServiceImpl(private val client: ProductLocationClient) :
    ProductLocationService {
    override suspend fun createProductLocation(location: ProductLocationRequest): Int {
        return client.createProductLocation(location).body<Int>()
    }

    override suspend fun deleteProductLocation(locationId: Int) {
        client.deleteProductLocation(locationId)
    }

    override suspend fun getProductLocationList(): Array<ProductLocation> {
        val response = client.getProductLocationList()
        when (response.status) {
            HttpStatusCode.OK -> {
                return response.body<Array<ProductLocation>>()
            }

            HttpStatusCode.BadRequest -> throw BadRequestException()
            HttpStatusCode.NoContent -> throw NoContentException()
            else -> throw UnknownStatusCodeException()
        }
    }


    @Deprecated("Not exist")
    override suspend fun updateProductLocation(locationId: Int, location: ProductLocationRequest) {
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