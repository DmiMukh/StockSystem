package ru.hackathone.core.inventoryApi.userAuth.client

import io.ktor.client.*
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse

class AuthClientKtor(providedKtorClient: HttpClient) : AuthClient {
    private var client: HttpClient = providedKtorClient
    private var addr: String = "http://localhost:90/"

    /**
    Sign in with the provided login and password.
    @param login the user's login
    @param password the user's password
    @return a string user's token and response status 200:OK or 400: BAD REQUEST */
    override suspend fun signIn(login: String, password: String): HttpResponse {
        return client.post("$addr/sign-in") {
            header("login", login)
            header("password", password)
        }
    }

    /**
    Sign up with the provided login and password.
    @param login the user's login
    @param password the user's password
    @return a response status 200:OK or 400: BAD REQUEST */
    override suspend fun signUp(login: String, password: String): HttpResponse {
        return client.post("$addr/sign-in") {
            header("login", login)
            header("password", password)
        }
    }
}