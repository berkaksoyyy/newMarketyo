package com.marketyo.platform.model.request

import com.google.gson.annotations.SerializedName

class LogRequest {
    @SerializedName("countSearchSize")
    var countSearchSize: Int? = null
    @SerializedName("searchString")
    var searchString: String? = null
    @SerializedName("targetProductName")
    var targetProductName: String? = null
    @SerializedName("targetProductId")
    var targetProductId: String? = null
    @SerializedName("trackingId")
    var trackingId: String? = null
    @SerializedName("client")
    var client: String? = null
}