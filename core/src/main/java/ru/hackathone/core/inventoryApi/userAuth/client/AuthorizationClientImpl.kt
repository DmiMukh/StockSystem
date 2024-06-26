package ru.hackathone.core.inventoryApi.userAuth.client

import io.ktor.client.*
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse

import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.hackathone.core.inventoryApi.userAuth.dto.AuthorizationRequest

class AuthorizationClientImpl(private val client: HttpClient) : AuthorizationClient {
    private var addr: String = "http://localhost:8080"

    /**
    Sign in with the provided login and password.
    @param login
    @param password
    @return a string user's token and response status 200:OK or 400: BAD REQUEST */
    override suspend fun signIn(login: String, password: String): HttpResponse {
        return client.post("$addr/auth/sign-in") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(AuthorizationRequest(login, password)))
        }
    }

    /**
    Sign up with the provided login and password.
    @param login
    @param password
    @return a int role_id and response status 200:OK or 400: BAD REQUEST */
    override suspend fun signUp(login: String, password: String): HttpResponse {
        return client.post("$addr/auth/sign-in") {
            contentType(ContentType.Application.Json)
            setBody(Json.encodeToString(AuthorizationRequest(login, password)))
        }
    }
}