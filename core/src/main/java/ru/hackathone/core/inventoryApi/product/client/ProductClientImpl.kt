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
import ru.hackathone.core.inventoryApi.product.dto.ProductRequest
import ru.hackathone.core.provideKtorHttpClient

class ProductClientImpl(
    private val client: HttpClient = provideKtorHttpClient(),
    val addr: String = "http://localhost:8081"
) : ProductClient {
    override suspend fun createProduct(product: ProductRequest): HttpResponse {
        return client.post("$addr/product") {
            contentType(ContentType.Application.Json)
            setBody(product)
        }
    }

    override suspend fun updateProduct(productId: Int, product: ProductRequest): HttpResponse {
        return client.put("$addr/product/$productId") {
            contentType(ContentType.Application.Json)
            setBody(product)
        }
    }

    override suspend fun deleteProduct(productId: Int): HttpResponse {
        return client.delete("$addr/product/$productId")
    }

    override suspend fun getProductList(): HttpResponse {
        return client.get("$addr/product")
    }
}