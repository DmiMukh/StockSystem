package ru.hackathone.core.inventoryApi.staff.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class TaskRequest(
    val title: String,
    val description: String,
    @SerialName("status_id")
    val statusId: Int,
    val userId: Int
)