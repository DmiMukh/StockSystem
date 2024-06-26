package ru.hackathone.core.inventoryApi.staff.models

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val statusId: Int,
    val userId: Int
)