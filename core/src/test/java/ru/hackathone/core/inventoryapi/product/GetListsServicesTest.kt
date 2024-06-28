package ru.hackathone.core.inventoryapi.product

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import ru.hackathone.core.inventoryApi.product.client.ProductCategoryClientImpl
import ru.hackathone.core.inventoryApi.product.client.ProductClientImpl
import ru.hackathone.core.inventoryApi.product.client.ProductLocationClientImpl
import ru.hackathone.core.inventoryApi.product.client.ProductStatusClientImpl
import ru.hackathone.core.inventoryApi.product.serviceImpl.ProductCategoryServiceImpl
import ru.hackathone.core.inventoryApi.product.serviceImpl.ProductLocationServiceImpl
import ru.hackathone.core.inventoryApi.product.serviceImpl.ProductServiceImpl
import ru.hackathone.core.inventoryApi.product.serviceImpl.ProductStatusServiceImpl

class GetListsServicesTest {
    private val product = ProductServiceImpl(ProductClientImpl())
    private val category = ProductCategoryServiceImpl(ProductCategoryClientImpl())
    private val location = ProductLocationServiceImpl(ProductLocationClientImpl())
    private val status = ProductStatusServiceImpl(ProductStatusClientImpl())

    @Test
    fun getProducts() = runBlocking {
        val response = product.getProductList()
        println(response)
        assertNotEquals(response.size, 0)
    }

    @Test
    fun getCategories() = runBlocking {
        val response = category.getProductCategoryList()
        println(response)
        assertNotEquals(response.size, 0)
    }

    @Test
    fun getStatuses() = runBlocking {
        val response = status.getProductStatusList()
        println(response)
        assertNotEquals(response.size, 0)
    }

    @Test
    fun getLocations() = runBlocking {
        val response = location.getProductLocationList()
        println("location: $response")
        assertNotEquals(response.size, 0)
    }
}