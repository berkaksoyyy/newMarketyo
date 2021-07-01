package com.marketyo.platform.model.address

import com.google.gson.annotations.SerializedName

/**
 * Createdby MBH on 17/01/2017.
 */

class City {

    @SerializedName("Id")
    var id: Long? = null
    @SerializedName("Name")
    var name: String? = null
    @SerializedName("Districts")
    var districts: List<District>? = emptyList()

    companion object {
        @JvmStatic
        fun findCityInList(cities: List<City>, cityString: String): Int {
            return cities.indexOfFirst { it.name.equals(cityString, true) }
        }
    }

}
