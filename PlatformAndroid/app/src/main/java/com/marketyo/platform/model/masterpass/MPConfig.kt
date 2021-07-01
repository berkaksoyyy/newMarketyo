package com.marketyo.platform.model.masterpass

import com.google.gson.annotations.SerializedName

data class MPConfig(
    @SerializedName("merchantId")
    val merchantId: String?
)

data class MPToken(
    @SerializedName("masterPass")
    val masterPass: MPTokenResponse?,
    @SerializedName("orderId")
    val orderId: String?
)

data class MPTokenResponse(
    @SerializedName("requestRefNo")
    val requestRefNo: String?,
    @SerializedName("token")
    val token: String?,
    @SerializedName("transactionId")
    val transactionId: String?
)

object MPProcess{
    val check = 5
    val process = 10
    val purchase = 15
}

