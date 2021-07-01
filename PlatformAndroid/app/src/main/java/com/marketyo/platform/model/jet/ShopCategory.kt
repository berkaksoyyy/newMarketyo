package com.marketyo.platform.model.jet

import com.google.gson.annotations.SerializedName


/**
 * CreatedBy mbh on 12/15/17.
 */


class ShopCategory(
    @SerializedName("id") val id: Int?, //1
    @SerializedName("name") val name: String?, //Mini Supermarket
    @SerializedName("icon") val icon: String?, //http://marketyo.com.tr/uploads/img/shops/types/mini-supermarket.svg
    @Transient var isSelected: Boolean = false
) {
    fun switchIsSelected() {
        isSelected = !isSelected
    }
}