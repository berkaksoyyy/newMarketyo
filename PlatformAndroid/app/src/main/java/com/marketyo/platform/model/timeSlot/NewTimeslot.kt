package com.marketyo.platform.model.timeSlot
import com.google.gson.annotations.SerializedName

data class NewTimeslot(
    @SerializedName("date")
    val date: String?,
    @SerializedName("timeSlots")
    var timeSlots: List<TimeSlotObj>?,
    @Transient
    var isFull: Boolean = true,
    @Transient
    var isExpanded: Boolean = true,
    @Transient
    var checkedOnce: Boolean = false
)

class TimeSlotObj(
    @SerializedName("endTime")
    val endTime: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("quote")
    val quote: Int?,
    @SerializedName("startTime")
    val startTime: String?,
    @SerializedName("totalQuote")
    val totalQuote: Int?,
    @Transient
    var isSelected: Boolean = false
) {
    val hasQuote : Boolean
        get() = (quote ?: 0) > 0
}