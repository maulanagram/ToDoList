package com.maulana.remote.datasource

import com.maulana.remote.requestbody.LoginRequestBody
import com.maulana.remote.response.LoginResponse
import com.maulana.remote.service.LoginService

class LoginRemoteDataSource(private val service: LoginService) {

    suspend fun login(userName: String, password: String): LoginResponse {
        val result = service.login(LoginRequestBody(userName, password))
        return LoginResponse(result.message, result.payload.token)
    }

}