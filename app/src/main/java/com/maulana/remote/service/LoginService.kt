package com.maulana.remote.service

import com.maulana.remote.requestbody.LoginRequestBody
import com.maulana.remote.response.BaseResponse
import com.maulana.remote.requestbody.LoginResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("/login")
    suspend fun login(@Body loginRequestBody: LoginRequestBody): BaseResponse<LoginResponseBody>

}