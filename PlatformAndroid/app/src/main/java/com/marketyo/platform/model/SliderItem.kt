package com.marketyo.platform.model

import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.core.ads.CSlider

class SliderItem(
        @SerializedName("magicLink")
    var magicLink: MagicLink? = null,
        @SerializedName("imageUrl")
    var imageUrl: String? = null,
        @SerializedName("title")
    var title: String? = null,
        @SerializedName("thumbnailUrl")
    var thumbnailUrl: String? = null,
        @SerializedName("priority")
    var priority: Int? = 0
) {
    companion object {
        @JvmStatic
        fun fromCoreSlider(cslider: CSlider): SliderItem {
            val sliderItem = SliderItem()
            sliderItem.imageUrl = cslider.imageUrl
            sliderItem.magicLink = cslider.magicLink
            sliderItem.thumbnailUrl = cslider.thumbnailUrl
            sliderItem.priority = cslider.priority
            sliderItem.title = ""
            return sliderItem
        }
    }
}
