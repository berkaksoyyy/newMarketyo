package com.marketyo.platform.model.user

import com.google.gson.annotations.SerializedName

class UserInfo {
    @SerializedName(value = "id")
    var id: String? = null
        get() = if (field == null) "userIDEmpty" else field
    @SerializedName(value = "Firstname", alternate = ["firstname"])
    var firstname: String? = null
    @SerializedName(value = "Lastname", alternate = ["lastname"])
    var lastname: String? = null
    @SerializedName(value = "Email", alternate = ["email"])
    var email: String? = null
    @SerializedName(value = "Birthday", alternate = ["birthday"])
    var birthday: String? = null
    @SerializedName(value = "IdGender", alternate = ["gender"])
    var idGender: String? = null
    @SerializedName(value = "phoneMobile", alternate = ["phoneNumber"])
    var phoneMobile: String? = null
    @SerializedName(value = "phoneNumberConfirmed")
    var phoneNumberConfirmed: Boolean = false
    @SerializedName(value = "contractsConfirmed")
    var contractsConfirmed: Boolean = false
    @SerializedName(value = "UserPreferences", alternate = ["userPreferences"])
    var userPreferences: UserPreferences? = null

    val fullName: String
        get() = (if (firstname == null) "" else firstname) + " " + if (lastname == null) "" else lastname
}
