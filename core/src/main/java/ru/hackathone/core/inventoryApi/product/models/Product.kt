package ru.hackathone.core.inventoryApi.product.models

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val quantity: Int,
    val description: String,
    val category: ProductCategory,
    val location: ProductLocation,
    val status: ProductStatus
)