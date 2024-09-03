package com.maulana.remote.requestbody

import com.google.gson.annotations.SerializedName

data class LoginRequestBody(
    @SerializedName("username")
    val userName:String,
    @SerializedName("password")
    val password:String,
)
