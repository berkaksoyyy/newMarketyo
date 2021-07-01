package com.marketyo.platform.model.request

import com.google.gson.annotations.SerializedName


/**
 * CreatedBy mbh on 3/19/18.
 */

data class ForgotMyPasswordRequest(
    @SerializedName("phoneNumber") var phoneNumber: String? = null,
    @SerializedName("newPassword") var newPassword: String? = null,
    @SerializedName("confirmPassword") var confirmPassword: String? = null,
    @SerializedName("verificationCode") var verificationCode: String? = null

)