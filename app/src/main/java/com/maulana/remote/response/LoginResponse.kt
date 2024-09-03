package com.maulana.remote.response

import androidx.core.app.NotificationCompat.MessagingStyle.Message
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val message: String?,
    val token: String?
)
