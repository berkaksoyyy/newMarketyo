package com.marketyo.platform.model.user

import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.coupon.CouponItem
import com.marketyo.platform.model.order.Client
import com.marketyo.platform.model.order.Order

data class UserOrdersInfo(
    @SerializedName("todaysOrders")
    val todaysOrders: List<Order?>?,
    @SerializedName("rateableOrder")
    val rateableOrder: RateableOrder?,
    @SerializedName("coupon")
    val coupon: CouponItem?
)

data class RateableOrder(

    @SerializedName("client")
    val client: Client?,
    @SerializedName("orderId")
    val orderId: String?

)
