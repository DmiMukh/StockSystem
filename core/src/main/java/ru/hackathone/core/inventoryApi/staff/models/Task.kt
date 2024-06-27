package ru.hackathone.core.inventoryApi.staff.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val id: Int,
    val title: String,
    val description: String,
    @SerialName("status_id")
    val statusId: Int,
    val userId: Int
)