package com.marketyo.platform.model.reponses

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.address.City
import java.util.*

/**
 * CreatedBy mbh on 11/29/17.
 */

class CitiesResponse {

    @SerializedName("Id")
    var id: Int? = null
    @SerializedName("Name")
    var name: String? = null
    @SerializedName("Cities")
    var cities: List<City> = ArrayList()

    fun toJson(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

    companion object {

        fun fromJson(json: String): CitiesResponse {
            val gson = Gson()
            return gson.fromJson(json, CitiesResponse::class.java)
        }
    }

}
