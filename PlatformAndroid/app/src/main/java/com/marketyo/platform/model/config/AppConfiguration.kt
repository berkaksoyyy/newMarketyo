package com.marketyo.platform.model.config

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

/**
 * CreatedBy mbh on 7/18/18.
 */

class AppConfiguration(
    @SerializedName("address") val address: ConfigurationAddress? = null,
    @SerializedName("applicationVersion") val serviceAppVersion: ServiceAppVersion? = null,
    @SerializedName("shoppingConfig") val shoppingConfig: ShopConfiguration? = null,
    @SerializedName("orderRatingText") val orderRatingText: String? = null
) {


    fun toJson(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

    companion object {
        @JvmStatic
        fun fromJson(json: String): AppConfiguration {
            val gson = Gson()
            return gson.fromJson(json, AppConfiguration::class.java)
        }
    }
}

data class ServiceAppVersion(
    @SerializedName("androidVersion")
    val androidVersion: Int?
)

class ShopConfiguration(
    @SerializedName("isCartProductNoteEnabled") val isCartProductNoteEnabled: Boolean? = null,
    @SerializedName("isQrSearchEnabled") val isQrSearchEnabled: Boolean? = null,
    @SerializedName("isFavouriteEnabled") val isFavouriteEnabled: Boolean? = null,
    @SerializedName("currency") val currency: Currency? = null,
    @SerializedName("isBagChangeable") val isBagChangeable: Boolean? = null,
    @SerializedName("timeSlotDayCount") val timeSlotDayCount: Int? = null
) {

    fun toJson(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

    companion object {
        @JvmStatic
        fun fromJson(json: String): ShopConfiguration {
            val gson = Gson()
            return gson.fromJson(json, ShopConfiguration::class.java)
        }
    }
}

data class Currency(
    @SerializedName("name") val name: String?,
    @SerializedName("symbol") val symbol: String?,
    @SerializedName("isSymbolAfter") val isSymbolAfter: Boolean?,
    @SerializedName("isoCode") val isoCode: String?,
    @SerializedName("numericIsoCode") val numericIsoCode: Int?
)


data class ConfigurationAddress(
    @SerializedName("labels") val labels: List<Label>?,
    @SerializedName("maxDepth") val maxDepth: Int?
)

data class Label(
    @SerializedName("label") val label: String?,
    @SerializedName("depth") val depth: Int?
)
