package ru.hackathone.core.inventoryapi.auth

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test
import ru.hackathone.core.inventoryApi.userAuth.dto.AuthorizationRequest

class SerializationTest {
    @Test
    fun serializationCorrect() {
        val json = Json.encodeToString(AuthorizationRequest("login", "123"))
        println(json)
        assertEquals(json, "{\"login\":\"login\",\"password\":\"123\"}")
    }
}