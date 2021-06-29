package com.marketyo.platform.utils

import android.content.Context
import android.os.Build
import java.util.*

/**
 * CreatedBy mbh on 10/27/17.
 */
object LocaleUtils {
    fun getCurrentLocale(context: Context): Locale {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.resources.configuration.locales[0]
        } else {
            // noinspection deprecation
            context.resources.configuration.locale
        }
    }

    fun getCurrentLocaleString(context: Context): String {
        return try {
            getCurrentLocale(context).language
        } catch (e: Exception) {
            "tr"
        }
    }
}