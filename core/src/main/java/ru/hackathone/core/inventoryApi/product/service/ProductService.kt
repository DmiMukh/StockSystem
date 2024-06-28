package ru.hackathone.core.inventoryApi.product.service

import ru.hackathone.core.inventoryApi.product.dto.ProductRequest
import ru.hackathone.core.inventoryApi.product.models.Product
import ru.hackathone.core.inventoryApi.product.models.ProductLocation

interface ProductService {
    /** @return id = 1 */
    suspend fun createProduct(product: ProductRequest): Int
    suspend fun updateProduct(productId: Int, product: ProductRequest)
    suspend fun deleteProduct(productId: Int)

    suspend fun getProductByName(productName: String): Product
    suspend fun getProductById(productId: Int): Product

    suspend fun getProductList(): Array<Product>

    suspend fun getProductListByCategoryId(categoryId: Int): Array<Product>
    suspend fun getProductListByCategoryName(categoryName: String): Array<Product>

    suspend fun getProductListByLocationId(locationId: Int): Array<Product>
    suspend fun getProductListByLocation(location: ProductLocation): Array<Product>

    suspend fun getProductListByStatusId(statusId: Int): Array<Product>
    suspend fun getProductListByStatusName(statusName: String): Array<Product>
}