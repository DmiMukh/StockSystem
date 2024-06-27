package ru.hackathone.core.inventoryApi.staff.models

data class Staff(
    val id: Int,
    val login: String,
    val roleId: Int,
    val fullName: String
)