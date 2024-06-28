package ru.hackathone.core.inventoryApi.product.serviceImpl

import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import ru.hackathone.core.inventoryApi.exceptions.BadRequestException
import ru.hackathone.core.inventoryApi.exceptions.NoContentException
import ru.hackathone.core.inventoryApi.exceptions.UnknownStatusCodeException
import ru.hackathone.core.inventoryApi.product.client.ProductCategoryClient
import ru.hackathone.core.inventoryApi.product.models.ProductCategory
import ru.hackathone.core.inventoryApi.product.service.ProductCategoryService

class ProductCategoryServiceImpl(private val client: ProductCategoryClient) :
    ProductCategoryService {
    override suspend fun getProductCategoryList(): Array<ProductCategory> {
        val response = client.getProductCategoryList()
        when (response.status) {
            HttpStatusCode.OK -> {
                return response.body<Array<ProductCategory>>()
            }

            HttpStatusCode.BadRequest -> throw BadRequestException()
            HttpStatusCode.NoContent -> throw NoContentException()
            else -> throw UnknownStatusCodeException()
        }
    }

    @Deprecated("Not implemented")
    override suspend fun getProductCategoryByName(categoryName: String): ProductCategory {
        TODO("Not yet implemented")
    }

    @Deprecated("Not implemented")
    override suspend fun getProductCategoryById(categoryId: Int): ProductCategory {
        TODO("Not yet implemented")
    }
}