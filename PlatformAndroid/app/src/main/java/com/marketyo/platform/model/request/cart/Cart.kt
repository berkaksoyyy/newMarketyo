

package com.marketyo.platform.model.request.cart

import com.google.gson.annotations.SerializedName

class Cart(
    @SerializedName("id") var id: String? = "",
    @SerializedName("idAddressDelivery") var idAddressDelivery: String? = "",
    @SerializedName("idAddressInvoice") var idAddressInvoice: String? = "",
    @SerializedName("idCurrency") var idCurrency: String? = "",
    @SerializedName("idCustomer") var idCustomer: String? = "",
    @SerializedName("idGuest") var idGuest: String? = "",
    @SerializedName("idCarrier") var idCarrier: String? = "",
    @SerializedName("bagCount") var bagCount: Int = 0,
    @SerializedName("idUserCoupon") var idUserCoupon: String? = null,
    @SerializedName("recommendedBagCount") var recommendedBagCount: Int = 0,
    @SerializedName("alternativeProductPreference") var alternativeProductPreference: Int = 0,
    // JET
    @SerializedName(value = "customerNote", alternate = ["CustomerNote"])
    var customerNote: String? = ""
) {
    constructor() : this("")
}

