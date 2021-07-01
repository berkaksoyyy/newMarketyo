package com.marketyo.platform.model.jet

import com.google.gson.annotations.SerializedName


/**
 * CreatedBy mbh on 12/15/17.
 */


data class ShopRequest(
    @SerializedName("Latitude") val latitude: Double?, //0
    @SerializedName("Longitude") val longitude: Double?, //0
    @SerializedName("searchKeyword") val searchKeyword: String? = null, //string
    @SerializedName("storeCategories") val storeCategories: String? = null //string
)


data class OrderCompleteRequest(
    @SerializedName("deliveryTime") val deliveryTime: String = "" //string
)