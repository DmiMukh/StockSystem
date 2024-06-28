package ru.hackathone.core.inventoryApi.staff.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TaskRequest(
    val title: String,
    val description: String,
    @SerialName("status_id")
    val statusId: Int,
    @SerialName("user_id")
    val userId: Int
)