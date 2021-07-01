package com.marketyo.platform.model

import android.view.View

/**
 * Createdby MBH on 03/07/2017.
 */

data class ImagedButtonItem(
    var imageRes: Int,
    var textRes: Int,
    var onClickListener: View.OnClickListener?
)
