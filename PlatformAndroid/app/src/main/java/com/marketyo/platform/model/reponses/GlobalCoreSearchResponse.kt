package com.marketyo.platform.model.reponses

import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.Category
import com.marketyo.platform.model.product.Product
import com.marketyo.platform.model.shop.Shop

data class GlobalCoreSearchResponse(
    @SerializedName("categories") val categories: List<Category>?,
    @SerializedName("products") val products: List<Product>?,
    @SerializedName("shop") val shops: Shop?
)