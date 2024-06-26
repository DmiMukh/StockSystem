package ru.hackathone.core.inventoryapi.auth

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertNotEquals
import org.junit.Test
import ru.hackathone.core.inventoryApi.userAuth.client.AuthorizationClientImpl
import ru.hackathone.core.inventoryApi.userAuth.service.AuthorizationServiceImpl
import ru.hackathone.core.provideKtorHttpClient

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class AuthServiceTest {
    private val authClient = AuthorizationClientImpl(provideKtorHttpClient())
    private val authService = AuthorizationServiceImpl(authClient)

    @Test
    fun signInCorrectRequest() {
        runBlocking {
            val token = authService.signIn("kotlin", "123")
            assertNotEquals(token, null)
        }
    }

    @Test
    fun signUpCorrectRequest() {
        runBlocking {
            val id = authService.signIn("kotlin", "123")
            assertNotEquals(id, null)
        }
    }
}