package com.marketyo.platform.model.address

import com.google.gson.annotations.SerializedName

/**
 * CreatedBy mbh on 11/29/17.
 */

class Neighborhood {
    @SerializedName("Id")
    var id: Long? = null
    @SerializedName("Name")
    var name: String? = null

    companion object {
        @JvmStatic
        fun findNeighborhoodInList(neighborhoods: List<Neighborhood>, neighborhoodString: String?): Int {
            if (neighborhoodString == null) return -1
            return neighborhoods.indexOfFirst { it.name.equals(neighborhoodString, true) }
        }
    }
}
