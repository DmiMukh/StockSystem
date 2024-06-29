package ru.hackathone.core.inventoryApi.userAuth.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignInResponse(
    @SerialName("user_id")
    val userId: Int,
    @SerialName("role_id")
    val roleId: Int,
    var token: String,
)