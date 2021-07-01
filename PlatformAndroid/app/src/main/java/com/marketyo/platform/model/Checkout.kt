package com.marketyo.platform.model

import com.google.gson.annotations.SerializedName

data class Checkout(
    @SerializedName("discount")
    var discount: String?
)
