package ru.hackathone.core.inventoryApi.userAuth.client

import io.ktor.client.statement.HttpResponse

interface AuthorizationClient {
    suspend fun signIn(login: String, password: String): HttpResponse
    suspend fun signUp(fullName:String, login: String, password: String, roleId: Int): HttpResponse
}