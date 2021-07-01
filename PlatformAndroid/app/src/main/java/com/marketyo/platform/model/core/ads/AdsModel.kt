package com.marketyo.platform.model.core.ads

import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.MagicLink
import com.marketyo.platform.model.shop.Shop


/**
 * CreatedBy mbh on 10/24/18.
 */

data class AdsModel(
    @SerializedName("popups") var popups: List<CPopup>? = emptyList(),
    @SerializedName("sliders") var sliders: List<CSlider>? = emptyList(),
    @SerializedName("carousels") var carousels: List<CCarousel>? = emptyList(),
    @SerializedName("icons") var icons: List<CIcon>? = emptyList()
)

open class CBaseAd(
    @SerializedName("id") val id: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("version") val version: String? = null,
    @SerializedName("advertiser") val advertiser: String? = null,
    @SerializedName("brand") val brand: String? = null,
    @SerializedName("pageType") val pageType: Int? = null,
    @SerializedName("pageKey") val pageKey: String? = null
)

data class CPopup(
        @SerializedName("imageUrl") val imageUrl: String?,
        @SerializedName("magicLink") val magicLink: MagicLink?,
        @SerializedName("isPlatform") var isPlatform: Boolean? = null
) : CBaseAd()

data class CIcon(
    @SerializedName("location") val location: Int?,
    @SerializedName("imageUrl") val imageUrl: String?,
    @SerializedName("target") val target: CTarget?,
    @SerializedName("magicLink") val magicLink: MagicLink?,
    @SerializedName("isPlatform") var isPlatform: Boolean? = null
) : CBaseAd()

data class CTarget(
    @SerializedName("type") val type: Int?,
    @SerializedName("payload") val payload: String?
) : CBaseAd()

data class CCarousel(
    @SerializedName("location") val location: Int?,
    @SerializedName("priority") val priority: Int?,
    @SerializedName("target") val target: CTarget?,
    @SerializedName("magicLink") val magicLink: MagicLink?,
    @SerializedName("isPlatform") var isPlatform: Boolean? = null
) : CBaseAd()

data class CSlider(
        @SerializedName("location") var location: Int? = null,
        @SerializedName("imageUrl") var imageUrl: String? = null,
        @SerializedName("thumbnailUrl") var thumbnailUrl: String? = null,
        @SerializedName("priority") var priority: Int? = null,
        @SerializedName("magicLink") var magicLink: MagicLink? = null,
        @SerializedName("isPlatform") var isPlatform: Boolean? = null,
        @SerializedName("shops") var shops: List<Shop>? = null

) : CBaseAd()