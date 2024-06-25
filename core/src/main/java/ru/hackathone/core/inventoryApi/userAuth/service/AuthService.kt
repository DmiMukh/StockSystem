package ru.hackathone.core.inventoryApi.userAuth.service

import io.ktor.client.call.body
import io.ktor.client.call.receive
import io.ktor.http.HttpStatusCode
import ru.hackathone.core.inventoryApi.userAuth.client.AuthClient
import ru.hackathone.core.inventoryApi.userAuth.dto.SignInResponse
import ru.hackathone.core.inventoryApi.userAuth.dto.SignUpResponse

class AuthService(private var client: AuthClient) {

    suspend fun signUp(login: String, password: String): Int {
        val response = client.signUp(login, password)
        when (response.status) {
            HttpStatusCode.OK -> {
                val signUpResponse = response.body<SignUpResponse>()
                return signUpResponse.id
            }

            HttpStatusCode.BadRequest -> throw Exception("Bad request")
            else -> throw Exception("Unknown status code")
        }
    }

    suspend fun signIn(login: String, password: String): String {
        val response = client.signIn(login, password)
        when (response.status) {
            HttpStatusCode.OK -> {
                val signInResponse = response.body<SignInResponse>()
                return signInResponse.token
            }

            HttpStatusCode.BadRequest -> throw Exception("Bad request")
            else -> throw Exception("Unknown status code")
        }
    }
}