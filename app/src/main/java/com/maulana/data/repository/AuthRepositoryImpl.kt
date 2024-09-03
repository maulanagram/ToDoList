package com.maulana.data.repository

import com.maulana.remote.datasource.LoginRemoteDataSource
import com.maulana.remote.response.LoginResponse
import com.maulana.repository.AuthRepository

class AuthRepositoryImpl(private val loginRemoteDataSource: LoginRemoteDataSource) :
    AuthRepository {
    override suspend fun login(userName: String, password: String): LoginResponse {
        return loginRemoteDataSource.login(userName, password)
    }
}