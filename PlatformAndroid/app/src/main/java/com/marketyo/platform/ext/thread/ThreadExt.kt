package com.marketyo.platform.ext.thread

import android.os.Handler
import android.os.Looper

typealias VoidFunc = (() -> Unit)

fun doAfter(milliSeconds: Long, func: VoidFunc) {
    Handler(Looper.getMainLooper()).postDelayed({
        func.invoke()
    }, milliSeconds)
}