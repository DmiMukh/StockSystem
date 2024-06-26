package ru.hackathone.core.inventoryApi.userAuth.dto

import kotlinx.serialization.Serializable

@Serializable
data class AuthorizationRequest (val login: String, val password: String)