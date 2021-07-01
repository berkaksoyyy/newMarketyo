package com.marketyo.platform.utils

import android.util.Log
import com.marketyo.platform.App.Companion.instance
import com.marketyo.platform.R
import com.marketyo.platform.base.constant.Constants.CURRENT_CURRENCY
import com.marketyo.platform.model.product.Product
import java.util.*

/**
 * Createdby MBH on 30/01/2017.
 */
object MathUtils {
    fun roundTo2Digits(numToRound: Float): Float {
        return Math.round(numToRound * 100f) / 100f
    }

    fun roundTo1Digit(numToRound: Float): Float {
        return Math.round(numToRound * 10f) / 10f
    }

    fun percentageOfNumber(value: Float, percentage: Float): Float {
        return value * (percentage / 100.0f)
    }

    fun limit(min: Float, value: Float, max: Float): Float {
        return Math.max(Math.min(value, max), min)
    }

    fun randInt(min: Int, max: Int): Int {
        return Random().nextInt(max - min + 1) + min
    }

    fun randFloat(min: Float, max: Float): Float {
        return Random().nextFloat() * (max - min) + min
    }

    fun getFormattedPrice(value: Float): String {
        Log.d("Format price", " $value")
        return instance!!.getString(
            R.string.formatted_price, CURRENT_CURRENCY,
            roundTo2Digits(value)
        )
    }

    fun getFormattedPriceWithoutFloating(value: Float): String {
        return instance!!.getString(
            R.string.formatted_price_no_floating, roundTo2Digits(value),
            CURRENT_CURRENCY
        )
    }

    fun getFormattedDistance(distanceInMeters: Double): String {
        return if (distanceInMeters < 1000.0) {
            roundTo1Digit(distanceInMeters.toFloat())
                .toString() + " Mt."
        } else {
            roundTo1Digit((distanceInMeters / 1000).toFloat())
                .toString() + " Km."
        }
    }

    fun getFormattedPrice(product: Product): String {
        return getFormattedPrice(product.price!!)
    }

    fun getFormattedPriceKiloAdet(isKg: Boolean, value: Float): String {
        val strId = if (isKg) R.string.formatted_price_kilo else R.string.formatted_price_adet
        return instance!!.getString(strId, CURRENT_CURRENCY, value)
    }

    fun getFormattedPriceKiloAdet(product: Product): String {
        return getFormattedPriceKiloAdet(product.isKg!!, product.price!!)
    }

    fun getHeightRelativeToBoundaryAndWidth(
        originalWidth: Int,
        originalHeight: Int,
        newWidth: Int
    ): Int {
        return newWidth * originalHeight / originalWidth
    }

    fun getFirstNChar(value: String, step: Int): String {
        return value.substring(0, Math.min(value.length, step))
    }

    fun takeFirsNCharUntilFindSpecialChar(value: String, ch: String): String {
        val splitValue = value.split(ch).toTypedArray()
        return if (ch == "\\s+") splitValue[0] else splitValue[0] + "." + getFirstNChar(
            splitValue[1],
            1
        )
    }
}