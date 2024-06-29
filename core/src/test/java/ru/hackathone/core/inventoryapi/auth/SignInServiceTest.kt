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
class SignInServiceTest {
    private val authClient = AuthorizationClientImpl(provideKtorHttpClient())
    private val authService = AuthorizationServiceImpl(authClient)

    @Test
    fun signInAdminRequest() = runBlocking {
        val user = authService.signIn("admin", "1")
        println("user = ${user.toString()}")
        assertNotEquals(user.userId, 1)
        assertNotEquals(user.roleId, 1)
    }
    @Test
    fun signInManagerRequest() = runBlocking {
        val user = authService.signIn("manager1", "2")
        println("user = ${user.toString()}")
        assertNotEquals(user.userId, 2)
        assertNotEquals(user.roleId, 2)
    }
    @Test
    fun signInWorker1Request() = runBlocking {
        val user = authService.signIn("worker1", "3")
        println("user = ${user.toString()}")
        assertNotEquals(user.userId, 3)
        assertNotEquals(user.roleId, 3)
    }
    @Test
    fun signInWorker2Request() = runBlocking {
        val user = authService.signIn("worker2", "4")
        println("user = ${user.toString()}")
        assertNotEquals(user.userId, 4)
        assertNotEquals(user.roleId, 3)
    }
}