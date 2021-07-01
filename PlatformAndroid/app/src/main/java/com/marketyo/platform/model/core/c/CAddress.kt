package com.marketyo.platform.model.core.c

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.core.CPlace

/**
 * CreatedBy mbh on 6/22/18.
 */
class CAddress(
    @SerializedName("id") var id: String? = null,
    @SerializedName("alias") var alias: String? = null,
    @SerializedName("firstName") var firstName: String? = null,
    @SerializedName("lastName") var lastName: String? = null,
    @SerializedName("postcode") var postcode: String? = null,
    @SerializedName("phoneNumber") var phoneNumber: String? = null,
    @SerializedName("fullAddress") var fullAddress: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("identityNumber") var identityNumber: String? = null,
    @SerializedName("company") var company: String? = null,
    @SerializedName("taxOffice") var taxOffice: String? = null,
    @SerializedName("taxId") var taxId: String? = null,
    @SerializedName("geoNameId") var geoNameId: String? = null,
    @SerializedName("geoNames") var geoNames: List<CPlace>? = null,
    @Transient var isSelected: Boolean = false
) : Parcelable {

    fun geoNameOfDepth(depth: Int): String = geoNames?.find { it.depth == depth }?.id ?: ""
    fun geoNameOfDepthCPlace(depth: Int): CPlace? = geoNames?.find { it.depth == depth }

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(CPlace)
    )

    fun toJson(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

    fun copy(): CAddress {
        return fromJson(this.toJson())
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(alias)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(postcode)
        parcel.writeString(phoneNumber)
        parcel.writeString(fullAddress)
        parcel.writeString(description)
        parcel.writeString(identityNumber)
        parcel.writeString(company)
        parcel.writeString(taxOffice)
        parcel.writeString(taxId)
        parcel.writeString(geoNameId)
        parcel.writeTypedList(geoNames)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CAddress> {
        override fun createFromParcel(parcel: Parcel): CAddress {
            return CAddress(parcel)
        }

        override fun newArray(size: Int): Array<CAddress?> {
            return arrayOfNulls(size)
        }

        @JvmStatic
        fun fromJson(json: String): CAddress {
            val gson = Gson()
            return gson.fromJson(json, CAddress::class.java)
        }

        @JvmStatic
        fun copy(address: CAddress?): CAddress {
            return if (address == null) CAddress() else fromJson(address.toJson())
        }
    }
}