package com.marketyo.platform.model.core

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.core.c.CAddress
import com.marketyo.platform.model.product.Product

data class CPlace(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("label") val label: String?,
    @SerializedName("depth") val depth: Int?
//        ,@SerializedName("children") val children: List<CPlace>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(label)
        parcel.writeValue(depth)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CPlace> {
        override fun createFromParcel(parcel: Parcel): CPlace {
            return CPlace(parcel)
        }

        override fun newArray(size: Int): Array<CPlace?> {
            return arrayOfNulls(size)
        }
    }
}

data class CUser(
    @SerializedName("email") val email: String?,
    @SerializedName("firstName") val firstName: String?,
    @SerializedName("lastName") val lastName: String?,
    @SerializedName("gender") val gender: Int?,
    @SerializedName("password") val password: String?,
    @SerializedName("passwordConfirmation") val passwordConfirmation: String?,
    @SerializedName("birthDate") val birthDate: String?,
    @SerializedName("phoneNumber") val phoneNumber: String?
)

data class CCart(
    @SerializedName("id") val id: String?,
    @SerializedName("idAddressDelivery") val idAddressDelivery: String?,
    @SerializedName("idAddressInvoice") val idAddressInvoice: String?,
    @SerializedName("idCarrier") val idCarrier: String?,
    @SerializedName("idCurrency") val idCurrency: String?,
    @SerializedName("idGuest") val idGuest: String?,
    @SerializedName("customerNote") val customerNote: String?
)


data class CCategory(
    @SerializedName("id") val id: String?,
    @SerializedName("idParent") val idParent: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("img") val img: String?,
    @SerializedName("priority") val priority: Int?
)

data class COrder(
    @SerializedName("id") val id: String?,
    @SerializedName("products") val products: List<Product>?,
    @SerializedName("addresses") val addresses: CAddresses?,
    @SerializedName("reference") val reference: String?,
    @SerializedName("status") val status: Int?,
    @SerializedName("deliveryFee") val deliveryFee: Double?,
    @SerializedName("total") val total: Double?,
    @SerializedName("carrier") val carrier: String?,
    @SerializedName("paymentMethod") val paymentMethod: String?,
    @SerializedName("note") val note: String?,
    @SerializedName("date") val date: String?,
    @SerializedName("deliveryDate") val deliveryDate: String?
)

data class CAddresses(
    @SerializedName("deliveryAddress") val deliveryAddress: CAddress?,
    @SerializedName("invoiceAddress") val invoiceAddress: CAddress?
)


data class CPaymentMethod(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?
)

data class CCartRules(
    @SerializedName("pieceStep") val pieceStep: Double?,
    @SerializedName("pieceInitialAmount") val pieceInitialAmount: Double?,
    @SerializedName("kgStep") val kgStep: Double?,
    @SerializedName("kgInitialAmount") val kgInitialAmount: Double?,
    @SerializedName("minimumCartPieceAmount") val minimumCartPieceAmount: Double?,
    @SerializedName("minimumCartKgAmount") val minimumCartKgAmount: Double?
)

// REQUESTS
data class CRUpdatePassword(
    @SerializedName("oldPassword") val oldPassword: String?,
    @SerializedName("password") val password: String?,
    @SerializedName("passwordConfirmation") val passwordConfirmation: String?
)

data class CRLogin(
    @SerializedName("username") val username: String?,
    @SerializedName("password") val password: String?
)

data class CRUpdateProduct(
    @SerializedName("idProduct") val idProduct: String?,
    @SerializedName("amount") val amount: Double?
)

data class CRUpdateProductNote(
    @SerializedName("idProduct") val idProduct: String?,
    @SerializedName("messsage") val messsage: String?
)

data class CRUpdateCartNote(
    @SerializedName("message") val message: String?
)

data class CRUpdateDeliveryTime(
    @SerializedName("deliveryTime") val deliveryTime: String?
)