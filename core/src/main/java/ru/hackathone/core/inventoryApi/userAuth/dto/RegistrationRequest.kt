package ru.hackathone.core.inventoryApi.userAuth.dto

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationRequest(
    val fullName: String,
    val login: String,
    val password: String,
    val roleId: Int
)