package com.marketyo.platform.model.request.update

import com.google.gson.annotations.SerializedName

data class UpdatePhoneNumberRequest(
    @SerializedName("phoneNumber") val phoneNumber: Long?
)