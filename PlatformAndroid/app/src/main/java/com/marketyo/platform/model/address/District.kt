package com.marketyo.platform.model.address

import com.google.gson.annotations.SerializedName

/**
 * CreatedBy mbh on 11/29/17.
 */

class District {
    @SerializedName("Id")
    var id: Long? = null
    @SerializedName("Name")
    var name: String? = null
    @SerializedName("Neighborhoods")
    var neighborhoods: List<Neighborhood>? = emptyList()

    companion object {
        @JvmStatic
        fun findDistrictInList(districts: List<District>, districtString: String?): Int {
            if (districtString == null) return -1
            return districts.indexOfFirst { it.name.equals(districtString, true) }
        }
    }
}
