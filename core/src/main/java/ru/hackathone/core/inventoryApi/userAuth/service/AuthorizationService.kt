package ru.hackathone.core.inventoryApi.userAuth.service

interface AuthorizationService {
    suspend fun signUp(login: String, password: String): Int
    suspend fun signIn(login: String, password: String): String
}