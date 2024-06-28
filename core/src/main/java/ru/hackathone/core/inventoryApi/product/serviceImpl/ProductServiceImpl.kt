package ru.hackathone.core.inventoryApi.product.serviceImpl

import ru.hackathone.core.inventoryApi.product.client.ProductClient
import ru.hackathone.core.inventoryApi.product.dto.ProductRequest
import ru.hackathone.core.inventoryApi.product.models.Product
import ru.hackathone.core.inventoryApi.product.models.ProductLocation
import ru.hackathone.core.inventoryApi.product.service.ProductService

class ProductServiceImpl(private val client: ProductClient) : ProductService {
    override suspend fun createProduct(product: ProductRequest): Int {
        TODO("Not yet implemented")
    }

    override suspend fun updateProduct(productId: Int, product: ProductRequest) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProduct(productId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun getProductList(): Array<Product> {
        TODO("Not yet implemented")
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