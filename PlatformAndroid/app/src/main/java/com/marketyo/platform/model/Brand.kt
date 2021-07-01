package com.marketyo.platform.model


import com.google.gson.annotations.SerializedName

data class Brand(
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @Transient
    var isSelected: Boolean = false,
    @Transient
    var isCampaign: Boolean = false,
    @Transient
    var isDiscount: Boolean = false
)