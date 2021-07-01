package com.marketyo.platform.model

import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.shop.Shop

class GlobalPromotions {

    @SerializedName("shops")
    var shops: List<Shop>? = null
    @SerializedName("promotion")
    var promotion: Promotion? = null


}