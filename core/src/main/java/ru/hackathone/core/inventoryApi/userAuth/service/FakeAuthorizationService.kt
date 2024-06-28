package ru.hackathone.core.inventoryApi.userAuth.service

class FakeAuthorizationService: AuthorizationService {
    override suspend fun signUp(
        fullName: String,
        login: String,
        password: String,
        roleId: Int
    ): Int {
        return -1
    }

    override suspend fun signIn(login: String, password: String): String {
        return "token"
    }
}