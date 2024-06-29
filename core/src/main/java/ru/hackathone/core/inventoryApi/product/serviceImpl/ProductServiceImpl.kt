package ru.hackathone.core.inventoryApi.product.serviceImpl

import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import ru.hackathone.core.inventoryApi.exceptions.BadRequestException
import ru.hackathone.core.inventoryApi.exceptions.NoContentException
import ru.hackathone.core.inventoryApi.exceptions.UnknownStatusCodeException
import ru.hackathone.core.inventoryApi.product.client.ProductClient
import ru.hackathone.core.inventoryApi.product.dto.ProductRequest
import ru.hackathone.core.inventoryApi.product.models.Product
import ru.hackathone.core.inventoryApi.product.models.ProductLocation
import ru.hackathone.core.inventoryApi.product.service.ProductService
import ru.hackathone.core.inventoryApi.staff.models.Id

class ProductServiceImpl(private val client: ProductClient) : ProductService {
    override suspend fun createProduct(product: ProductRequest): Int {
        return client.createProduct(product).body<Id>().id
    }

    override suspend fun updateProduct(productId: Int, product: ProductRequest) {
        client.updateProduct(productId, product)
    }

    override suspend fun deleteProduct(productId: Int) {
        client.deleteProduct(productId)
    }

    override suspend fun getProductList(): Array<Product> {
        val response = client.getProductList()
        when (response.status) {
            HttpStatusCode.OK -> {
                return response.body<Array<Product>>()
            }

            HttpStatusCode.BadRequest -> throw BadRequestException()
            HttpStatusCode.NoContent -> throw NoContentException()
            else -> throw UnknownStatusCodeException()
        }
    }


    @Deprecated("Not implemented")
    override suspend fun getProductByName(productName: String): Product {
        TODO("Not yet implemented")
    }

    @Deprecated("Not implemented")
    override suspend fun getProductById(productId: Int): Product {
        TODO("Not yet implemented")
    }

    @Deprecated("Not implemented")
    override suspend fun getProductListByCategoryId(categoryId: Int): Array<Product> {
        TODO("Not yet implemented")
    }

    @Deprecated("Not implemented")
    override suspend fun getProductListByCategoryName(categoryName: String): Array<Product> {
        TODO("Not yet implemented")
    }

    @Deprecated("Not implemented")
    override suspend fun getProductListByLocationId(locationId: Int): Array<Product> {
        TODO("Not yet implemented")
    }

    @Deprecated("Not implemented")
    override suspend fun getProductListByLocation(location: ProductLocation): Array<Product> {
        TODO("Not yet implemented")
    }

    @Deprecated("Not implemented")
    override suspend fun getProductListByStatusId(statusId: Int): Array<Product> {
        TODO("Not yet implemented")
    }

    @Deprecated("Not implemented")
    override suspend fun getProductListByStatusName(statusName: String): Array<Product> {
        TODO("Not yet implemented")
    }
}