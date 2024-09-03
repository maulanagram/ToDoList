package com.maulana.remote.response

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException


data class BaseResponse<T>(
    @SerializedName("message")
    val message: String,

    @SerializedName("data")
    val payload: T,

    @SerializedName("errorMessage")
    val errorMessage: String?,

    @SerializedName("error")
    val error: Boolean?,

    @SerializedName("statusCode")
    val success: Int?,
)

fun <T> BaseResponse<T>.validate(): BaseResponse<T> {
    if (error == true) {
        throw HttpException(
            retrofit2.Response.error<T>(
                403,
                Gson().toJson(this)
                    .toResponseBody("plain/text".toMediaTypeOrNull())
            )
        )
    } else {
        return this
    }
}

