package com.marketyo.platform.model.request.cart

import com.google.gson.annotations.SerializedName

class CartMessageRequest(
    @field:SerializedName("message")
    var message: String?
) {
    companion object {

        @JvmStatic
        fun fromMessage(message: String): CartMessageRequest {
            return CartMessageRequest(message)
        }
    }
}
