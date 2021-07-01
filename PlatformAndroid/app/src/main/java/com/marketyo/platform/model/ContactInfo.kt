package com.marketyo.platform.model

import com.google.gson.annotations.SerializedName


/**
 * CreatedBy mbh on 3/16/18.
 */
data class ContactInfo(
    @SerializedName("description") val description: String?,
    @SerializedName("callCenterPhone") val callCenterPhone: String?,
    @SerializedName("customerServiceEmail") val customerServiceEmail: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("tradeIdentity") val tradeIdentity: String?,
    @SerializedName("address") val address: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("mersis") val mersis: String?,
    @SerializedName("kep") val kep: String? // kayitli email posta
)