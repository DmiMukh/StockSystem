package ru.hackathone.core.inventoryApi.userAuth.service

import ru.hackathone.core.inventoryApi.userAuth.dto.SignInResponse

class FakeAuthorizationService: AuthorizationService {
    override suspend fun signUp(
        fullName: String,
        login: String,
        password: String,
        roleId: Int
    ): Int {
        return -1
    }

    override suspend fun signIn(login: String, password: String): SignInResponse {
        return SignInResponse(1,1,"token")
    }
}