package ru.hackathone.core.inventoryApi.product.models
import kotlinx.serialization.Serializable

@Serializable
data class ProductLocation(
    val id: Int,
    val row: String,
    val place: String
)