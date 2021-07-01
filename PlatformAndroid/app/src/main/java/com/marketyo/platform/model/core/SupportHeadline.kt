package com.marketyo.platform.model.core

import com.google.gson.annotations.SerializedName


/**
 * CreatedBy mbh on 10/16/18.
 */


data class SupportHeadline(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?
)


data class SupportMessage(
    @SerializedName("supportHeadlineId") val supportHeadlineId: String?,
    @SerializedName("message") val message: String?,
    @SerializedName("orderReference") val orderReference: String?,
    @SerializedName("supportHeadlineType") val supportHeadlineType: Int?
    )