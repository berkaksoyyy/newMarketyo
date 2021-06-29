package com.marketyo.platform.utils.fonts

import android.content.Context
import android.graphics.Typeface

/**
 * Createdby MBH on 23/01/2017.
 */
object FontsOverride {
    fun setDefaultFont(
        context: Context,
        staticTypefaceFieldName: String, fontAssetName: String?
    ) {
        val regular = Typeface.createFromAsset(
            context.assets,
            fontAssetName
        )
        replaceFont(staticTypefaceFieldName, regular)
    }

    private fun replaceFont(
        staticTypefaceFieldName: String,
        newTypeface: Typeface
    ) {
        try {
            val staticField = Typeface::class.java
                .getDeclaredField(staticTypefaceFieldName)
            staticField.isAccessible = true
            staticField[null] = newTypeface
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}