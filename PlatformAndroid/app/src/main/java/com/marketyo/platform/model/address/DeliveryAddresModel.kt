package com.marketyo.platform.model.address

import com.marketyo.platform.model.PickUp
import com.marketyo.platform.model.core.c.CAddress

data class DeliveryAddresModel(
    val selectedAddress: CAddress,
    val location: PickUp? = null,
    val carrierName: String? = null
)