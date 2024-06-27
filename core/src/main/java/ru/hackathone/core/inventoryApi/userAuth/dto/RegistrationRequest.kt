package ru.hackathone.core.inventoryApi.userAuth.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegistrationRequest(
    @SerialName("full_name")
    val fullName: String,
    val login: String,
    val password: String,
    @SerialName("role_id")
    val roleId: Int
)