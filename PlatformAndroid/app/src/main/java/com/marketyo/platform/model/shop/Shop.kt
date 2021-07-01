package com.marketyo.platform.model.shop

import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.carrier.Carrier
import com.marketyo.platform.model.payment.PaymentProvider

data class Shop(
    @SerializedName(value = "Provider", alternate = ["provider"])
    var provider: String? = null,
    @SerializedName(value = "Key", alternate = ["key"])
    var key: String? = null,
    @SerializedName(value = "Name", alternate = ["name"])
    var name: String? = null,
    @SerializedName(value = "ShopId", alternate = ["shopId"])
    var shopId: String? = null,
    @SerializedName(value = "Stats", alternate = ["stats"])
    var stats: List<Stats?>? = null,
    @SerializedName(value = "PaymentProviders", alternate = ["paymentProviders"])
    var paymentProviders: ShopsPaymentProviders? = null,
    @SerializedName(value = "Carriers", alternate = ["carriers"])
    var carriers: List<Carrier>? = null,
    @SerializedName(value = "logo", alternate = ["Logo"])
    val logo: String? = null,
    @Transient
    var isExpanded: Boolean? = false,
    @Transient
    var coverImage: Int? = null
)

data class McProductShops(
    @Transient
    var shop: Shop? = null,
    @Transient
    var productPrice: Float? = null,
)

data class Stats(
    @SerializedName(value = "ValueText", alternate = ["valueText"])
    var valueText: String? = null,
    @SerializedName(value = "Name", alternate = ["name"])
    var name: String? = null,
    @SerializedName(value = "Value", alternate = ["value"])
    var value: String? = null,
    @SerializedName(value = "EnumType", alternate = ["enumType"])
    var enumType: Int? = null,
    @Transient
    var isInfo: Boolean = false
)

data class ShopsPaymentProviders(
    @SerializedName(value = "Groups", alternate = ["groups"])
    var groups: Any? = null,
    @SerializedName(value = "Providers", alternate = ["providers"])
    var providers: List<PaymentProvider>? = null
)