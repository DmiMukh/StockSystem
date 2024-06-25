package ru.hackathone.core.inventoryApi.userAuth.service

import io.ktor.client.call.body
import io.ktor.client.call.receive
import io.ktor.http.HttpStatusCode
import ru.hackathone.core.inventoryApi.exceptions.BadRequestException
import ru.hackathone.core.inventoryApi.exceptions.UnknownStatusCodeException
import ru.hackathone.core.inventoryApi.userAuth.client.AuthClient
import ru.hackathone.core.inventoryApi.userAuth.dto.SignInResponse
import ru.hackathone.core.inventoryApi.userAuth.dto.SignUpResponse

class AuthService(private var client: AuthClient) {
    /**
    Sign-Up with the provided login and password.
    @login : String
    @password : String
    @return role-id: Int
    Can trow:
    NoTransformationFoundException if responded json don't match DTO Class
    BadRequestException if server responded 400 aka wrong parameters
    UnknownStatusCodeException for else responded statuses */
    suspend fun signUp(login: String, password: String): Int {
        val response = client.signUp(login, password)
        when (response.status) {
            HttpStatusCode.OK -> {
                val signUpResponse = response.body<SignUpResponse>()
                return signUpResponse.id
            }

            HttpStatusCode.BadRequest -> throw BadRequestException()
            else -> throw UnknownStatusCodeException()
        }
    }

    /**
    Sign-In with the provided login and password.
    @login : String
    @password : String
    @return token : String
    Can trow:
    NoTransformationFoundException if responded json don't match DTO Class
    BadRequestException if server responded 400 aka wrong parameters
    UnknownStatusCodeException for else responded statuses */
    suspend fun signIn(login: String, password: String): String {
        val response = client.signIn(login, password)
        when (response.status) {
            HttpStatusCode.OK -> {
                val signInResponse = response.body<SignInResponse>()
                return signInResponse.token
            }

            HttpStatusCode.BadRequest -> throw BadRequestException()
            else -> throw UnknownStatusCodeException()
        }
    }
}