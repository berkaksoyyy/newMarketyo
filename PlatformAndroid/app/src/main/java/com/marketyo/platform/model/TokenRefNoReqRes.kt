package com.marketyo.platform.model

import com.google.gson.annotations.SerializedName

data class TokenRefNoReqRes(
    @SerializedName("refNo")
    val refNo: String?,
    @SerializedName("token")
    val token: String?,
    @SerializedName("orderNo")
    val orderNo: String? = ""
)