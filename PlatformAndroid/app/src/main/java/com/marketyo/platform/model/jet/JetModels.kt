package com.marketyo.platform.model.jet

import com.google.gson.annotations.SerializedName
import java.util.*


/**
 * CreatedBy mbh on 3/16/18.
 */

data class JetAddress(
    @SerializedName("id") var id: String?,
    @SerializedName("alias") var alias: String?,
    @SerializedName("firstName") var firstName: String?,
    @SerializedName("lastName") var lastName: String?,
    @SerializedName("phone") var phone: String?,
    @SerializedName("latitude") var latitude: Double?,
    @SerializedName("longitude") var longitude: Double?,
    @SerializedName("fullAddress") var fullAddress: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("building") var building: String?,
    @SerializedName("floor") var floor: String?,
    @SerializedName("apartment") var apartment: String?,
    @SerializedName("postcode") var postcode: String?,
    @SerializedName("mapsAddress") var mapsAddress: String?,
    @SerializedName("mapsCountry") var mapsCountry: String?,
    @SerializedName("mapsCity") var mapsCity: String?,
    @SerializedName("mapsDistrict") var mapsDistrict: String?,
    @SerializedName("mapsNeighbourhood") var mapsNeighbourhood: String?
)

data class JetProductNoteRequest(
    @SerializedName("idProduct") var idProduct: String?,
    @SerializedName("messsage") var messsage: String?
)

class Time(
    val hour: Int = 0,
    val min: Int = 0
) : Comparable<Time> {

    override fun compareTo(other: Time): Int = when {
        hour == other.hour && min == other.min -> 0 // equal
        hour < other.hour || (hour == other.hour && min < other.min) -> -1 // lhs < rhs
        else -> 1 // lhs > rhs
    }


    companion object {
        fun create(date: Date): Time {
            val cal = Calendar.getInstance()
            cal.time = date
            return Time(hour = cal.get(Calendar.HOUR_OF_DAY), min = cal.get(Calendar.MINUTE))
        }

        fun create(time: String): Time? {
            val parts = time.split(":")
            if (parts.count() > 1) {
                val hour = parts[0].toIntOrNull()
                val min = parts[1].toIntOrNull()
                if (hour != null && min != null) {
                    return Time(hour, min)
                }
            }
            return null
        }

        fun isOpen(open: Time, close: Time): Boolean {
            val isClosingAfterMidnight: Boolean = close.hour < open.hour
            val currentTime = create(Date())

            if (isClosingAfterMidnight) {
                return !(currentTime > close && currentTime < open)
            }
            return currentTime >= open && currentTime < close
        }
    }
}