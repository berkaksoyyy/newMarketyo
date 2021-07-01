package com.marketyo.platform.model
import com.google.gson.annotations.SerializedName


data class PickUp(
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