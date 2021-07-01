package com.marketyo.platform.model.reponses

import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.Category
import com.marketyo.platform.model.product.Product


/**
 * CreatedBy mbh on 9/7/18.
 */

data class CoreSearchResponse(
        @SerializedName("categories") val categories: List<Category>?,
        @SerializedName("products") val products: List<Product>?
)