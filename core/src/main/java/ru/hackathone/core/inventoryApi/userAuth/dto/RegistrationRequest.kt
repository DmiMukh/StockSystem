package ru.hackathone.core.inventoryApi.userAuth.dto

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationRequest(
    val full_name: String,
    val login: String,
    val password: String,
    val role_id: Int
)