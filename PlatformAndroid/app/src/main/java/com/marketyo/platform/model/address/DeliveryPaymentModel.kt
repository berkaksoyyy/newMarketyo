package com.marketyo.platform.model.address

import androidx.recyclerview.widget.RecyclerView
import com.marketyo.platform.model.payment.PaymentProvider

data class DeliveryPaymentModel(
//    val adapter: PaymentTypeAdapter,
    val paymentType: PaymentProvider,
    val paymentProviderList: List<PaymentProvider>,
    val rvPayments: RecyclerView
)