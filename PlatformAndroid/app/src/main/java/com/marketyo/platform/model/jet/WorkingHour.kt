package com.marketyo.platform.model.jet

import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.jet.Time

/**
 * CreatedBy mbh on 12/13/17.
 */


class WorkingHour(
    @SerializedName("id") var id: Int?, //225
    @SerializedName("weekday") var weekday: Int?, //0
    @SerializedName("openingAt") var openingAt: String?, //09:00:00
    @SerializedName("closingAt") var closingAt: String?, //23:00:00
    @SerializedName("dayOff") var dayOff: Boolean? // false
) {
    val isOpened: Boolean?
        get() {
            val open = Time.create(openingAt ?: "")
            val close = Time.create(closingAt ?: "")
            if (open != null && close != null) {
                return Time.isOpen(open, close)
            }
            return null
        }
}