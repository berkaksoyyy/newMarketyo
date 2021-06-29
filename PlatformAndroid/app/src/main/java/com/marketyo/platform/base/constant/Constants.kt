package com.marketyo.platform.base.constant

import android.content.Context
import com.marketyo.platform.R
import com.marketyo.platform.utils.LocaleUtils

object Constants {

    var WS_BASE_URL = ""
    var CURRENT_LANGUAGE = "tr"


    fun prepareFieldsFromXML(context: Context) {
        WS_BASE_URL = context.getString(R.string.ws_base_url)
        CURRENT_LANGUAGE = LocaleUtils.getCurrentLocaleString(context)
    }
}