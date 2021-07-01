package com.marketyo.platform.model.order

import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.product.Product


data class Order(
    @SerializedName("addresses")
    val addresses: Addresses?,
    @SerializedName("bagCount")
    val bagCount: Int?,
    @SerializedName("carrier")
    val carrier: String?,
    @SerializedName("client")
    val client: Client?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("deliveryAt")
    val deliveryAt: String?,
    @SerializedName("deliveryDate")
    val deliveryDate: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("invoiceStatus")
    val invoiceStatus: String?,
    @SerializedName("invoiceStatusCode")
    val invoiceStatusCode: Int?,
    @SerializedName("isCancelable")
    val isCancelable: Boolean?,
    @SerializedName("isRateable")
    val isRateable: Boolean?,
    @SerializedName("isSlotSwitchable")
    val isSlotSwitchable: Boolean?,
    @SerializedName("note")
    val note: String?,
    @SerializedName("paymentMethod")
    val paymentMethod: String?,
    @SerializedName("paymentStatus")
    val paymentStatus: String?,
    @SerializedName("paymentStatusCode")
    val paymentStatusCode: Int?,
    @SerializedName("pickLocation")
    val pickLocation: PickLocation?,
    @SerializedName("products")
    val products: List<Product?>?,
    @SerializedName("reference")
    val reference: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("statusCode")
    val statusCode: Int?,
    @SerializedName("total")
    val total: Double?,
    @SerializedName("totalBagPrice")
    val totalBagPrice: Double?,
    @SerializedName("totalCampaignDiscount")
    val totalCampaignDiscount: Double?,
    @SerializedName("totalCouponDiscount")
    val totalCouponDiscount: Double?,
    @SerializedName("totalDelivery")
    val totalDelivery: Double?,
    @SerializedName("totalProduct")
    val totalProduct: Double?,
    @SerializedName("totalProductWithoutDiscount")
    val totalProductWithoutDiscount: Double?,
    @SerializedName("totalSubTotal")
    val totalSubTotal: Double?
)