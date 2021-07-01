package com.marketyo.platform.model.address

import com.google.gson.annotations.SerializedName

/**
 * Createdby MBH on 17/01/2017.
 */

data class Country(
    @SerializedName("Id")
    var id: Long?,
    @SerializedName("Name")
    var name: String?,
    @SerializedName("cities")
    var cities: List<String>?
)
