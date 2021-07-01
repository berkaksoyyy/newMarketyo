package com.marketyo.platform.model.order

import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.product.Product


data class OrderDetails(
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
    @SerializedName("cancelInformationMessage")
    val cancelInfoMsg: String?,
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
    @SerializedName("totalGross")
    val totalGross: Double?,
    @SerializedName("totalProductDiscount")
    val totalProductDiscount: Double?,
    @SerializedName("totalDeliveryDiscount")
    val totalDeliveryDiscount: Double?,
    @SerializedName("totalFinalDiscount")
    val totalFinalDiscount: Double?,
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
    val totalSubTotal: Double?,
    @SerializedName("cartTotal")
    val cartTotal: Double?,
    @SerializedName("orderRatings")
    val orderRatings: List<OrderRatings?>?,
    @SerializedName("orderScore")
    val orderScore: OrderScoreObj?
)

data class Addresses(
    @SerializedName("deliveryAddress")
    val deliveryAddress: DeliveryAddress?,
    @SerializedName("invoiceAddress")
    val invoiceAddress: InvoiceAddress?
)

data class DeliveryAddress(
    @SerializedName("alias")
    val alias: String?,
    @SerializedName("company")
    val company: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("fullAddress")
    val fullAddress: String?,
    @SerializedName("geoNameId")
    val geoNameId: String?,
    @SerializedName("geoNames")
    val geoNames: List<GeoName?>?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("identityNumber")
    val identityNumber: String?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("phoneNumber")
    val phoneNumber: String?,
    @SerializedName("postcode")
    val postcode: String?,
    @SerializedName("shopId")
    val shopId: String?,
    @SerializedName("taxId")
    val taxId: String?,
    @SerializedName("taxOffice")
    val taxOffice: String?
)

data class GeoName(
    @SerializedName("depth")
    val depth: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
)

data class InvoiceAddress(
    @SerializedName("alias")
    val alias: String?,
    @SerializedName("company")
    val company: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("firstName")
    val firstName: String?,
    @SerializedName("fullAddress")
    val fullAddress: String?,
    @SerializedName("geoNameId")
    val geoNameId: String?,
    @SerializedName("geoNames")
    val geoNames: List<GeoNameX?>?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("identityNumber")
    val identityNumber: String?,
    @SerializedName("lastName")
    val lastName: String?,
    @SerializedName("phoneNumber")
    val phoneNumber: String?,
    @SerializedName("postcode")
    val postcode: String?,
    @SerializedName("shopId")
    val shopId: String?,
    @SerializedName("taxId")
    val taxId: String?,
    @SerializedName("taxOffice")
    val taxOffice: String?
)

data class GeoNameX(
    @SerializedName("depth")
    val depth: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
)

data class Client(
    @SerializedName("clientKey")
    val clientKey: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("logo")
    val logo: String?
)

data class PickLocation(
    @SerializedName("address")
    val address: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("name")
    val name: String?
)

data class ApplicableDiscount(
    @SerializedName("discountId")
    val discountId: String?,
    @SerializedName("hasPromotion")
    val hasPromotion: Boolean?,
    @SerializedName("label")
    val label: String?,
    @SerializedName("promotionId")
    val promotionId: String?,
    @SerializedName("assignedToOrderSubTotal")
    val assignedToOrderSubTotal: Boolean?,
    @SerializedName("description")
    val description: String?,
    @Transient
    var isApplied: Boolean = false,
    @Transient
    var isExpanded: Boolean = false
)

data class Attribute(
    @SerializedName("name")
    val name: String?,
    @SerializedName("value")
    val value: String?
)

data class Badge(
    @SerializedName("colorCode")
    val colorCode: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("value")
    val value: String?
)

data class ImportantInformation(
    @SerializedName("enumType")
    val enumType: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("value")
    val value: String?
)

data class NutritionFact(
    @SerializedName("enumType")
    val enumType: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("value")
    val value: String?
)


data class OrderRatings(
    @SerializedName("name")
    val name: String?,
    @SerializedName("hasRating")
    val hasRating: Boolean?,
    @SerializedName("hasComment")
    val hasComment: Boolean?,
    @SerializedName("rate")
    val rate: Int?,
    @SerializedName("comment")
    val comment: String?,
)

data class OrderRatingsObj(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("hasRating")
    val hasRating: Boolean?,
    @SerializedName("hasComment")
    val hasComment: Boolean?,
    @Transient
    var rate: Float? = 0f,
    @Transient
    var comment: String? = null
)

data class OrderRatingsRequest(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("rate")
    var rate: Int? = null,
    @SerializedName("comment")
    var comment: String? = null,
)

data class OrderCancelReasons(
    @Transient
    var title: String? = "",
    @Transient
    var key: Int? = 0,
    @Transient
    var isSelected: Boolean? = false
)

data class OrderCancelRequest(
    @SerializedName("reason")
    var reason: Int?,
    @SerializedName("description")
    var description: String?,
)
