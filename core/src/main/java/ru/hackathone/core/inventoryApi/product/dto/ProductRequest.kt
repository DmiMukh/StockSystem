package ru.hackathone.core.inventoryApi.product.dto

import kotlinx.serialization.Serializable
import ru.hackathone.core.inventoryApi.product.models.ProductCategory
import ru.hackathone.core.inventoryApi.product.models.ProductLocation
import ru.hackathone.core.inventoryApi.product.models.ProductStatus

@Serializable
data class ProductRequest(
    val name: String,
    val quantity: Int,
    val description: String,
    val category: ProductCategory,
    val location: ProductLocation,
    val status: ProductStatus
)