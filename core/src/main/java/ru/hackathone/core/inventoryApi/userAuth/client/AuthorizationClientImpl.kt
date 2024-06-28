package ru.hackathone.core.inventoryApi.userAuth.client

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import ru.hackathone.core.inventoryApi.userAuth.dto.AuthorizationRequest
import ru.hackathone.core.inventoryApi.userAuth.dto.RegistrationRequest


class AuthorizationClientImpl(
    private val client: HttpClient,
    private val addr: String = "http://localhost:8080"
) : AuthorizationClient {
    /**
    Sign in with the provided login and password.
    @param login
    @param password
    @return a string user's token and response status 200:OK or 400: BAD REQUEST */
    override suspend fun signIn(login: String, password: String): HttpResponse {
        return client.post("$addr/auth/sign-in") {
            contentType(ContentType.Application.Json)
            setBody(AuthorizationRequest(login, password))
        }
    }

    /**
    Sign up with the provided login and password.
    @param login
    @param password
    @return a int role_id and response status 200:OK or 400: BAD REQUEST */
    override suspend fun signUp(
        fullName: String,
        login: String,
        password: String,
        roleId: Int
    ): HttpResponse {
        return client.post("$addr/auth/sign-up") {
            contentType(ContentType.Application.Json)
            setBody(RegistrationRequest(fullName, login, password, roleId))
        }
    }
}