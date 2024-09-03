package com.maulana.repository

import com.maulana.remote.response.LoginResponse

interface AuthRepository {

    suspend fun login(userName: String, password: String): LoginResponse

}