package com.marketyo.platform.model.order

import com.google.gson.annotations.SerializedName

class OrderScoreObj(
    @SerializedName("rate")
    var rate: Int? = null,
    @SerializedName("comment")
    var comment: String? = null
)