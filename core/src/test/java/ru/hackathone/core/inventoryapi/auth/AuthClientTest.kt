package ru.hackathone.core.inventoryapi.auth

import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import ru.hackathone.core.inventoryApi.userAuth.client.AuthorizationClientImpl
import ru.hackathone.core.provideKtorHttpClient

class AuthClientTest {
    private val authClient = AuthorizationClientImpl(provideKtorHttpClient())

    @Test
    fun signUpCorrectRequest() {
        runBlocking {
            val response = authClient.signUp("Linus Torwalds","kotlin", "123", 1)
            println(response.status)
            println(HttpStatusCode.fromValue(208))
            assertEquals(response.status, HttpStatusCode.fromValue(208))
        }
    }
    @Test
    fun signInCorrectRequest() {
        runBlocking {
            val response = authClient.signIn("kotlin", "123")
            println(response.status)
            println(HttpStatusCode.OK)
            assertEquals(response.status, HttpStatusCode.OK)
        }
    }
}