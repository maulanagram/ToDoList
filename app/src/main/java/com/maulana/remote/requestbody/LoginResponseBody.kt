package com.maulana.remote.requestbody

import com.google.gson.annotations.SerializedName

data class LoginResponseBody(
    @SerializedName("token")
    val token: String?,
)
