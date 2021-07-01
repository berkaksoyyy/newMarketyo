package com.marketyo.platform.model.payment

import com.google.gson.annotations.SerializedName

class PaymentData {
    @SerializedName("groups") val paymentGroups: List<PaymentGroups>? = null
    @SerializedName("providers") val paymentProviders: List<PaymentProvider>? = null
}
