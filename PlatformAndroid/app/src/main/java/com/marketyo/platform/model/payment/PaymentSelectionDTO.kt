package com.marketyo.platform.model.payment

import com.marketyo.platform.model.payment.PaymentProvider


data class PaymentSelectionDTO(
    var isSelected: Boolean,
    val provider: PaymentProvider
)
//    : PaymentRadioAdapter.RadioAdapterItem {
//    override fun getIsSelected(): Boolean {
//        return isSelected
//    }
//
//    override fun getPaymentProvider(): PaymentProviders {
//        return provider!!
//    }
//}