package ru.hackathone.core.inventoryapi.product

import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import ru.hackathone.core.inventoryApi.product.client.ProductCategoryClientImpl
import ru.hackathone.core.inventoryApi.product.client.ProductClientImpl
import ru.hackathone.core.inventoryApi.product.client.ProductLocationClientImpl
import ru.hackathone.core.inventoryApi.product.client.ProductStatusClientImpl

class GetListsClientTest {
    private val productClient = ProductClientImpl()
    private val categoryClient = ProductCategoryClientImpl()
    private val locationClient = ProductLocationClientImpl()
    private val statusClient = ProductStatusClientImpl()

    @Test
    fun getProducts() = runBlocking {
        val response = productClient.getProductList()
        println(response.bodyAsText())
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun getCategories() = runBlocking {
        val response = categoryClient.getProductCategoryList()
        println(response.bodyAsText())
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun getStatuses() = runBlocking {
        val response = statusClient.getProductStatusList()
        println(response.bodyAsText())
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun getLocations() = runBlocking {
        val response = locationClient.getProductLocationList()
        println(response.bodyAsText())
        assertEquals(HttpStatusCode.OK, response.status)
    }
}