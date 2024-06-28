package ru.hackathone.core.inventoryApi.product.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductLocationRequest(
    val row: String,
    val place: String
)