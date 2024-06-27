package ru.hackathone.core.inventoryApi.userAuth.dto

import kotlinx.serialization.Serializable

@Serializable
data class SignInResponse(var token: String)