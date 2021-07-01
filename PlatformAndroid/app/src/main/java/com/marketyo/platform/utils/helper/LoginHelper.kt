package com.marketyo.platform.utils.helper

import com.marketyo.platform.base.constant.Constants.CURRENT_ADDRESS
import com.marketyo.platform.prefs.EasySharedPref.setUserInfoWithToken
import com.marketyo.platform.prefs.EasySharedPref.token
import java.util.concurrent.atomic.AtomicBoolean

object LoginHelper {
    private var USER_TOKEN: String? = ""
    private val isUserLoggedIn = AtomicBoolean(false)

    fun token(): String? {
        if (USER_TOKEN!!.isEmpty()) {
            USER_TOKEN = token
            if (USER_TOKEN!!.isEmpty()) {
                isUserLoggedIn.set(false)
            } else {
                isUserLoggedIn.set(true)
            }
        }
        return USER_TOKEN
    }

    private fun updateToken() {
        USER_TOKEN = ""
        token()
    }

    fun login(username: String?, password: String?, token: String?) {
        isUserLoggedIn.set(true)
        setUserInfoWithToken(username, password, token)
        updateToken()

        //TODO: Open updateFromWS somehow
//        GlobalCoreConfig.getInstance().updateFromWS();
//        EventBusUtils.INSTANCE.safePost(new EBLoginLogoutUpdate());
//        FBAnalytics.logLoginEvent();
    }

    fun logout() {
        USER_TOKEN = ""
        isUserLoggedIn.set(false)
        setUserInfoWithToken("", "", "")

        //TODO: open GlobalCart.getInstance().clear() somehow
//        GlobalCart.getInstance().clear();
        CURRENT_ADDRESS = null
        //        EventBusUtils.INSTANCE.safePost(new EBLoginLogoutUpdate());
    }

    fun isUserLoggedIn(): Boolean {
        return isUserLoggedIn.get()
    }
}