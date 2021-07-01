package com.marketyo.platform.model.coupon

import com.google.gson.annotations.SerializedName
import java.util.*

data class CouponWithDiscount(
    var id: String? = null,
    var label: String? = null,
    var desc: String? = null,
    var couponReason: List<String>? = null,
    var isApplicable: Boolean? = null,
    var isActive: Boolean? = null,
    var endDate: Date? = null,
    var type: String? = null,
    var targetCount: Int? = null,
    var currentCount: Int? = null,
    var loyaltyType: Int? = null
)