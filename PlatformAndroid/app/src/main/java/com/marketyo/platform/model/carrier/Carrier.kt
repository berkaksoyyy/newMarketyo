package com.marketyo.platform.model.carrier

import com.google.gson.annotations.SerializedName

class Carrier(
    @SerializedName("description")
    var description: String?,
    @SerializedName("id")
    var id: String?,
    @SerializedName("img")
    var image: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("hasTimeSlot")
    var hasTimeSlot: Boolean?,
    @SerializedName("type")
    var type: Int?,
    @SerializedName("Options")
    var options: List<CarrierOption>?,
    @SerializedName("orderLimit")
    var orderLimit: Float?,
    @SerializedName("freeShippingLimit")
    var freeShippingLimit: Float?,
    @SerializedName("shippingFee")
    var shippingFee: Float?,
    @Transient
    var isSelected: Boolean = false
) {
    fun hasTimeSlots(): Boolean {
        return hasTimeSlot ?: false
    }

//    fun hasCarrierOptions(): Boolean {
//        return options?.isNotEmpty() == true
//    }

    companion object {
        val TYPE_ADDRESS_DELIVERY = 1
        val TYPE_COME_AND_TAKE = 3

        fun getName(carrier: Carrier): String? {
            return carrier.name
        }

        @JvmStatic
        fun isSupportedType(carrier: Carrier): Boolean {
            return isSupportedType(carrier.type!!)
        }

        @JvmStatic
        fun isSupportedType(type: Int): Boolean {
            return type == TYPE_ADDRESS_DELIVERY || type == TYPE_COME_AND_TAKE
        }
    }
}
