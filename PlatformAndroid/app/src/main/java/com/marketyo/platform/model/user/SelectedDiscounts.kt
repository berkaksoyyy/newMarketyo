package com.marketyo.platform.model.user

import com.google.gson.annotations.SerializedName

data class SelectedDiscounts(
    @SerializedName("applied")
    val applied: Boolean?,

    @SerializedName("validationErrors")
    val validationErrors: MutableList<String>?,

    @SerializedName("discountId")
    val discountId: String?,

    @SerializedName("label")
    val label: String?,

    @SerializedName("hasPromotion")
    val hasPromotion: Boolean?,

    @SerializedName("promotionId")
    val promotionId: String?,

    @SerializedName("assignedToOrderSubTotal")
    val assignedToOrderSubTotal: Boolean?,

    @SerializedName("description")
    val description: String?

)