package com.marketyo.platform.model.core.c

import com.google.gson.annotations.SerializedName

/**
 * CreatedBy mbh on 6/26/18.
 */

//data class CUserCart(
//        @SerializedName("cart") val cart: Cart?,
//        @SerializedName("products") val products: List<Product>?,
//        @SerializedName("minOrderLimit") val minOrderLimit: Float?,
//        @SerializedName("freeShippingLimit") val freeShippingLimit: Float?,
//        @SerializedName("shippingFee") val shippingFee: Float?,
//        @SerializedName("productTotal") val productTotal: Float?,
//        @SerializedName("cartTotal") val cartTotal: Float?
//)


data class CampaignDetail(
    @SerializedName("title") val title: String?,
    @SerializedName("discountTotal") val discountTotal: Float?
)