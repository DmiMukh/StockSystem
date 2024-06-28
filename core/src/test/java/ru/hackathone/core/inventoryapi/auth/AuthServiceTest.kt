package ru.hackathone.core.inventoryapi.auth

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
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
    fun signUpCorrectRequest() = runBlocking {
        val roleId = 1;
        val expectedId = authService.signUp("Linus Torwalds", "kotlin", "123", roleId)
        println("role-id = $expectedId")
        assertEquals(roleId, expectedId)
    }


    @Test
    fun signInCorrectRequest() = runBlocking {
        val token = authService.signIn("kotlin", "123")
        println("token = $token")
        assertNotEquals(token, null)
    }

}