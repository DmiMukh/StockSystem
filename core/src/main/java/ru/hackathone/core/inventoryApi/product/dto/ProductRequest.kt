package ru.hackathone.core.inventoryApi.product.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductRequest(
    val name: String,
    val quantity: Int,
    val description: String,
    val category: Int,
    val location: Int,
    val status: Int
)