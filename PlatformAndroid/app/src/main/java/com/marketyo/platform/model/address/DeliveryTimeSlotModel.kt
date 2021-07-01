package com.marketyo.platform.model.address

import com.marketyo.platform.model.timeSlot.TimeSlotObj

data class DeliveryTimeSlotModel(
    val timeSlot: TimeSlotObj,
    val day: String
)