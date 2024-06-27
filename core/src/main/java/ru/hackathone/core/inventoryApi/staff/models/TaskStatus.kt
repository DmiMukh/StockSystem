package ru.hackathone.core.inventoryApi.staff.models
import kotlinx.serialization.Serializable

@Serializable
data class TaskStatus (
    val id: Int,
    val name: String
)
