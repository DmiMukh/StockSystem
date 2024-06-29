package ru.hackathone.core.inventoryApi.product.serviceImpl

import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import ru.hackathone.core.inventoryApi.exceptions.BadRequestException
import ru.hackathone.core.inventoryApi.exceptions.NoContentException
import ru.hackathone.core.inventoryApi.exceptions.UnknownStatusCodeException
import ru.hackathone.core.inventoryApi.product.client.ProductStatusClient
import ru.hackathone.core.inventoryApi.product.models.ProductStatus
import ru.hackathone.core.inventoryApi.product.service.ProductStatusService

class ProductStatusServiceImpl(private val client: ProductStatusClient) : ProductStatusService {
    override suspend fun getProductStatusList(): Array<ProductStatus> {
        val response = client.getProductStatusList()
        when (response.status) {
            HttpStatusCode.OK -> {
                return response.body<Array<ProductStatus>>()
            }

            HttpStatusCode.BadRequest -> throw BadRequestException()
            HttpStatusCode.NoContent -> throw NoContentException()
            else -> throw UnknownStatusCodeException()
        }
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