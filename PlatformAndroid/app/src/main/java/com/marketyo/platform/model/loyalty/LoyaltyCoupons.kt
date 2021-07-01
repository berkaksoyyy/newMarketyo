package com.marketyo.platform.model.loyalty

import com.google.gson.annotations.SerializedName
import java.util.*

data class LoyaltyCoupons(

	@field:SerializedName("loyaltyEndAt")
	val loyaltyEndAt: Date? = null,

	@field:SerializedName("terms")
	val terms: String? = null,

	@field:SerializedName("progresses")
	val progresses: List<ProgressesItem?>? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("endAt")
	val endAt: String? = null,

	@field:SerializedName("startAt")
	val startAt: String? = null
)

data class ProgressesItem(

	@field:SerializedName("current")
	val current: Int? = null,

	@field:SerializedName("type")
	val type: Int? = null,

	@field:SerializedName("target")
	val target: Int? = null
)
