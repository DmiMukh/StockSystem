package ru.hackathone.core.inventoryApi.staff.dto

data class Product(
    val id: Int,
    val name: String,
    val quantity: Int,
    val description: String,
    val categoryId: Int,
    val locationId: Int,
    val statusId: Int
)