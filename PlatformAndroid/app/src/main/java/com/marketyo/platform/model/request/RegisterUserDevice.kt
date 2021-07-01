package com.marketyo.platform.model.request

import com.google.gson.annotations.SerializedName


/**
 * CreatedBy mbh on 3/19/18.
 */

data class RegisterUserDevice(
    @SerializedName("onesignalToken") val onesignalToken: String?,
    @SerializedName("onesignalAppId") val onesignalAppId: String?
)