package com.marketyo.platform.utils

/**
 * Createdby MBH on 15/02/2017.
 */
object ThreadUtils {
    fun fireNForget(runnable: Runnable?) {
        Thread(runnable).start()
    }

    fun fireNForget(runnable: Runnable, canShout: Boolean) {
        Thread {
            if (canShout) {
                runnable.run()
            } else {
                try {
                    runnable.run()
                } catch (ignored: Exception) {
                }
            }
        }.start()
    }
}