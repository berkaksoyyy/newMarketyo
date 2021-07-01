package com.marketyo.platform.model.request

import com.google.gson.annotations.SerializedName

data class PhoneVerificationRequest(
    @SerializedName("verificationCode") val verificationCode: String?
)