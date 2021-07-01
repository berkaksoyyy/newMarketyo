package com.marketyo.platform.model.carrier

import com.google.gson.annotations.SerializedName

data class CarrierOption(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?
)
