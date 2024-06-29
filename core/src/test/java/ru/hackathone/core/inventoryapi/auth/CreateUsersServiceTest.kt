package ru.hackathone.core.inventoryapi.auth

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import ru.hackathone.core.inventoryApi.userAuth.client.AuthorizationClientImpl
import ru.hackathone.core.inventoryApi.userAuth.service.AuthorizationServiceImpl
import ru.hackathone.core.provideKtorHttpClient

class CreateUsersServiceTest {
    private val authClient = AuthorizationClientImpl(provideKtorHttpClient())
    private val authService = AuthorizationServiceImpl(authClient)

    @Test
    fun createAdmin() = runBlocking {
        val userId = 1;
        val expectedId = authService.signUp("Linus Torwalds", "admin", "1", 1)
        println("userid = $expectedId")
        assertEquals(userId, expectedId)
    }
    @Test
    fun createManager() = runBlocking {
        val userId = 2;
        val expectedId = authService.signUp("Mr.Beast", "manager1", "2", 2)
        println("userid = $expectedId")
        assertEquals(userId, expectedId)
    }
    @Test
    fun createWorker1() = runBlocking {
        val userId = 3;
        val expectedId = authService.signUp("Worker 1", "worker1", "3", 3)
        println("userid = $expectedId")
        assertEquals(userId, expectedId)
    }
    @Test
    fun createWorker2() = runBlocking {
        val userId = 4;
        val expectedId = authService.signUp("Worker 2", "worker2", "4", 3)
        println("userid = $expectedId")
        assertEquals(userId, expectedId)
    }
}