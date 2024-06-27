package ru.hackathone.core.inventoryApi.staff.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Staff(
    val id: Int,
    val login: String,
    @SerialName("role_id")
    val roleId: Int,
    @SerialName("full_name")
    val fullName: String
)