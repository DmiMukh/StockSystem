package ru.hackathone.core.inventoryapi.auth

import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import org.junit.Test
import ru.hackathone.core.inventoryApi.userAuth.client.AuthorizationClientImpl
import ru.hackathone.core.inventoryApi.userAuth.service.AuthorizationServiceImpl
import ru.hackathone.core.provideKtorHttpClient

class AuthClientTest {
    private val authClient = AuthorizationClientImpl(provideKtorHttpClient())

    @Test
    fun signInCorrectRequest() {
        runBlocking {
            val response = authClient.signIn("kotlin", "123")
            assertNotEquals(response.status, HttpStatusCode.OK)
        }
    }

    @Test
    fun signUpCorrectRequest() {
        runBlocking {
            val response = authClient.signIn("kotlin", "123")
            assertNotEquals(response.status, HttpStatusCode.OK)
        }
    }
}