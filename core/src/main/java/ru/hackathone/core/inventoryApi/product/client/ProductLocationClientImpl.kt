package ru.hackathone.core.inventoryApi.product.client

import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import ru.hackathone.core.inventoryApi.product.dto.ProductLocationRequest
import ru.hackathone.core.provideKtorHttpClient

class ProductLocationClientImpl(
    private val client: HttpClient = provideKtorHttpClient(),
    private val addr: String = "http://localhost:8081"
) : ProductLocationClient {
    override suspend fun createProductLocation(location: ProductLocationRequest): HttpResponse {
        return client.post("$addr/product/location") {
            contentType(ContentType.Application.Json)
            setBody(location)
        }
    }

    override suspend fun deleteProductLocation(locationId: Int): HttpResponse {
        return client.delete("$addr/product/location/$locationId")
    }

    override suspend fun getProductLocationList(): HttpResponse {
        return client.get("$addr/product/location")
    }

    @Deprecated("Not exist")
    override suspend fun updateProductLocation(
        locationId: Int,
        location: ProductLocationRequest
    ): HttpResponse {
        return client.put("$addr/product/$locationId") {
            contentType(ContentType.Application.Json)
            setBody(location)
        }
    }
}