package com.marketyo.platform.model

import com.google.gson.annotations.SerializedName

class Promotion {
    @SerializedName("id")
    var id: String? = null
    @SerializedName("images")
    var images: List<String>? = null
    @SerializedName("hasProducts")
    var hasProducts: Boolean = false
    @SerializedName("title")
    var title: String? = null
    @SerializedName("shortDescription")
    var shortDescription: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("productId")
    var productId: List<String>? = null

    val coverImage: String
        get() {
            return if (this.images?.isEmpty() == true) "" else images?.firstOrNull() ?: ""
        }
}