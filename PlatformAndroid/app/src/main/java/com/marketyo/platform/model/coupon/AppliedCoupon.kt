package com.marketyo.platform.model.coupon

import com.google.gson.annotations.SerializedName

data class AppliedCoupon(
    @SerializedName("name")
    val name: String?,
    @SerializedName("label")
    val label: String?
)