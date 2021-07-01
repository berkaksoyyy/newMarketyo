package com.marketyo.platform.model.payment

import com.google.gson.annotations.SerializedName

/**
 * CreatedBy mbh on 12/24/17.
 */

//
//class PaymentMethod(
//    @SerializedName("id") val id: Int?,
//    @SerializedName("Name") val name: String?, //bbb
//    @SerializedName("Url") val url: String? //http://www.cc.ee)) : PaymentMethodBase(
//
//) : BaseRadioAdapter.RadioAdapterItem {
//    override fun getText(): String {
//        return name ?: ""
//    }
//}

class PaymentMethod(
    @SerializedName("id") val id: String? = null,
    @SerializedName("type") val type: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("shortDescription") val shortDescription: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("logo") val logo: String? = null,
    @SerializedName("priority") val priority: String? = null ){

//) : BaseRadioAdapter.RadioAdapterItem {
//    override fun getProviderType(): Int {
//        return type!!
//    }
//
//    override fun getText(): String {
//        return name ?: ""
//    }

}

//class PaymentMethodBase(var isSelected: Boolean = false)