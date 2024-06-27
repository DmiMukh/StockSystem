package ru.hackathone.core.inventoryApi.userAuth.service

interface AuthorizationService {
    suspend fun signUp(fullName:String, login: String, password: String, roleId: Int): Int
    suspend fun signIn(login: String, password: String): String
}