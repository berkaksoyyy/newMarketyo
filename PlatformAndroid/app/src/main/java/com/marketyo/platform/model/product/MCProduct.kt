package com.marketyo.platform.model.product

import com.google.gson.annotations.SerializedName

class MCProduct {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("images")
    var images: List<String>? = null
}