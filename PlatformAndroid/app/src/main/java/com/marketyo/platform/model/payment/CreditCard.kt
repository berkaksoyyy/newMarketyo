package com.marketyo.platform.model.payment

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class CreditCard(
    @SerializedName("cardHolderName")
    var cardHolderName: String?,
    @SerializedName("cardNumber")
    var cardNumber: String?,
    @SerializedName("expireMonth")
    var expireMonth: String?,
    @SerializedName("expireYear")
    var expireYear: String?,
    @SerializedName("cvv")
    var cvv: String?,
    @SerializedName("is3D")
    var is3d: Boolean?,
    @SerializedName("installement")
    var installement: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cardHolderName)
        parcel.writeString(cardNumber)
        parcel.writeString(expireMonth)
        parcel.writeString(expireYear)
        parcel.writeString(cvv)
        parcel.writeValue(is3d)
        parcel.writeString(installement)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CreditCard> {
        override fun createFromParcel(parcel: Parcel): CreditCard {
            return CreditCard(parcel)
        }

        override fun newArray(size: Int): Array<CreditCard?> {
            return arrayOfNulls(size)
        }
    }
}
