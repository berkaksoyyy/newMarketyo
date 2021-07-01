package com.marketyo.platform.model.request.update

import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.product.Product

/**
 * Createdby MBH on 08/03/2017.
 */

class UpdateProductRequest(
    @SerializedName("idProduct")
    var productId: String,
    @SerializedName("amount")
    var amount: Float = 0f
) {
    companion object {
        @JvmStatic
        fun fromProduct(product: Product): UpdateProductRequest {
            return UpdateProductRequest(product.id ?: "", product.currentAmount)
        }
    }

}
