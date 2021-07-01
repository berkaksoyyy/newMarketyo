package com.marketyo.platform.model.coupon

import com.google.gson.annotations.SerializedName
import java.util.*

class CouponItem(
    @SerializedName("id")
    var couponId: String? = null,
    @SerializedName("title")
    var couponTitle: String? = null,
    @SerializedName("description")
    var couponDescription: String? = null,
    @SerializedName("startAt")
    var couponStartAt: Any? = null,
    @SerializedName("endAt")
    var couponEndAt: Date? = null,
    @SerializedName("isActive")
    var couponIsActive: Boolean? = null,
    @SerializedName("isApplicable")
    var couponIsApplicable: Boolean? = null,
    @SerializedName("reason")
    var couponReason: List<String>? = null,
    @SerializedName("cartTotalMinimum")
    var couponCartTotalMinimum: Any? = null,
    @SerializedName("discountValue")
    var couponDiscountValue: Any? = null
)