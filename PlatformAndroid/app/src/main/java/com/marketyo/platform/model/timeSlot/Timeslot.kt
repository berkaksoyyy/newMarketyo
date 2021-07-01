package com.marketyo.platform.model.timeSlot

import com.google.gson.annotations.SerializedName
import java.util.*

class Timeslot(
    @SerializedName("startTime")
    var timeStart: String? = null,
    @SerializedName("available")
    var available: Long? = null,
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("endTime")
    var timeEnd: String? = null,
    @SerializedName("quote")
    var quote: Int? = null,
    @Transient
    var date: Date? = null,
    @Transient
    var color: Int? = null,
    @Transient
    var isSelected: Boolean = false
) {
    constructor(timeStart: String?) : this() {
        this.timeStart = timeStart
    }
}
