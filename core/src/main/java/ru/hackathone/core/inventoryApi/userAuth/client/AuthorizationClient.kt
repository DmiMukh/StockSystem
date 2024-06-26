package ru.hackathone.core.inventoryApi.userAuth.client

import io.ktor.client.statement.HttpResponse

interface AuthorizationClient {
    suspend fun signIn(login: String, password: String): HttpResponse
    suspend fun signUp(login: String, password: String): HttpResponse
}