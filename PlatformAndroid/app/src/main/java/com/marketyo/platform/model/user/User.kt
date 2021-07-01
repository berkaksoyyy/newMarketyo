package com.marketyo.platform.model.user

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName(value = "BirthDate", alternate = ["birthDate"])
    var birthDate: String? = null,
    @SerializedName(value = "CitizenshipNumber", alternate = ["citizenshipNumber"])
    var citizenshipNumber: String? = null,
    @SerializedName(value = "Email", alternate = ["email"])
    var email: String? = null,
    @SerializedName(value = "FirstName", alternate = ["firstName"])
    var firstName: String? = null,
    @SerializedName(value = "Gender", alternate = ["gender"])
    var gender: Long? = null,
    @SerializedName(value = "Id", alternate = ["id"])
    var id: String? = null,
    @SerializedName(value = "LastName", alternate = ["lastName"])
    var lastName: String? = null,
    @SerializedName(value = "Password", alternate = ["password"])
    var password: String? = null,
    @SerializedName(value = "PasswordConfirmation", alternate = ["passwordConfirmation"])
    var passwordConfirmation: String? = null,
    @SerializedName(value = "OldPassword", alternate = ["oldPassword"])
    var oldPassword: String? = null,
    @SerializedName(value = "phoneNumber", alternate = ["phoneMobile"])
    var phoneMobile: String? = null,
    @SerializedName(value = "verificationCode", alternate = ["VerificationCode"])
    var verificationCode: String? = null,
    @SerializedName(value = "referer", alternate = ["Referer"])
    var referer: String? = null,
    @SerializedName(value = "Contract", alternate = ["contract"])
    var contract: Contract? = null,

    )

data class Contract(
    @SerializedName(value = "kvkContractConfirmed")
    var kvkContractConfirmed: Boolean = false,
    @SerializedName(value = "etkContractConfirmed")
    var etkContractConfirmed: Boolean = false,
    @SerializedName(value = "membershipConfirmed")
    var membershipConfirmed: Boolean = false
)

data class UpdateContractObj(
    @SerializedName(value = "kvkContractConfirmed")
    var kvkContractConfirmed: Boolean = false,
    @SerializedName(value = "etkContractConfirmed")
    var etkContractConfirmed: Boolean = false,
    @SerializedName(value = "membershipContractConfirmed")
    var membershipConfirmed: Boolean = false
)

class UserPreferences(
    @SerializedName(value = "emailCommunicationPermission")
    val emailCommunicationPermission: Boolean?,
    @SerializedName(value = "textMessageCommunicationPermission")
    val textMessageCommunicationPermission: Boolean?,
    @SerializedName(value = "phoneCallCommunicationPermission")
    val phoneCallCommunicationPermission: Boolean?
)