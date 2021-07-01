package com.marketyo.platform.model.payment

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class PaymentResult (
    @SerializedName("form") val form: String? = null,
    @SerializedName("orderId") val orderId: String? = null
)

data class PTResponseForm(
    @SerializedName("result")
    val formResult: FormResult?,
    @SerializedName("asyncState")
    val asyncState: Any?,
    @SerializedName("creationOptions")
    val creationOptions: Int?,
    @SerializedName("exception")
    val exception: Any?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("isCanceled")
    val isCanceled: Boolean?,
    @SerializedName("isCompleted")
    val isCompleted: Boolean?,
    @SerializedName("isCompletedSuccessfully")
    val isCompletedSuccessfully: Boolean?,
    @SerializedName("isFaulted")
    val isFaulted: Boolean?,
    @SerializedName("status")
    val status: Int?
)

data class FormResult(
    @SerializedName("errorMessages")
    val errorMessages: Any?,
    @SerializedName("informationMessages")
    val informationMessages: Any?,
    @SerializedName("succeeded")
    val succeeded: Boolean?,
    @SerializedName("value")
    val value: String?,
    @SerializedName("warningMessages")
    val warningMessages: Any?
) : Serializable