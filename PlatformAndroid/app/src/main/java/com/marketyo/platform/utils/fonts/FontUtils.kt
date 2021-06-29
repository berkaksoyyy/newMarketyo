package com.marketyo.platform.utils.fonts

import android.content.Context
import android.graphics.Typeface
import android.util.SparseArray
import androidx.annotation.IntRange
import com.marketyo.platform.App
import com.marketyo.platform.R

/**
 * Createdby MBH on 23/01/2017.
 */
object FontUtils {
    private val fontMap = SparseArray<Typeface>()

    @JvmStatic
    fun getFont(
        @IntRange(
            from = Typeface.NORMAL.toLong(),
            to = Typeface.BOLD.toLong()
        ) style: Int = Typeface.NORMAL
    ): Typeface {
        if (fontMap.size() == 0) {
            val appFontNameWithPath =
                "fonts/" + App.instance?.getString(R.string.app_new_font_medium)
            val appBolFontNameWithPath =
                "fonts/" + App.instance?.getString(R.string.app_new_font_bold)
            val assetManager = App.instance?.assets
            fontMap.append(
                Typeface.NORMAL,
                Typeface.createFromAsset(assetManager, appFontNameWithPath)
            )
            fontMap.append(
                Typeface.BOLD,
                Typeface.createFromAsset(assetManager, appBolFontNameWithPath)
            )
        }
        return fontMap[style]
    }

    @JvmStatic
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