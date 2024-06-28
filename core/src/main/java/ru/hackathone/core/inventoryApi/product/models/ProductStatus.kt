package ru.hackathone.core.inventoryApi.product.models
import kotlinx.serialization.Serializable

@Serializable
data class ProductStatus(
    val id: Int,
    val name: String
)