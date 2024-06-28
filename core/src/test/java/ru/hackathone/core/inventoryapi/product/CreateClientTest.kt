package ru.hackathone.core.inventoryapi.product

import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import ru.hackathone.core.inventoryApi.product.client.ProductClientImpl
import ru.hackathone.core.inventoryApi.product.client.ProductLocationClientImpl
import ru.hackathone.core.inventoryApi.product.dto.ProductLocationRequest
import ru.hackathone.core.inventoryApi.product.dto.ProductRequest

class CreateClientTest {
    private val productClient = ProductClientImpl()
    private val locationClient = ProductLocationClientImpl()

    @Test
    fun createProduct() = runBlocking {
        val product = ProductRequest(
            "Linus Torvalds",
            12400000,
            "Linux rule",
            3,
            1,
            1
        )
        val response = productClient.createProduct(product)
        println(response.bodyAsText())
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun createLocations() = runBlocking {
        val location = ProductLocationRequest("23", "B")

        val response = locationClient.createProductLocation(location)
        assertEquals(HttpStatusCode.OK, response.status)
    }
}