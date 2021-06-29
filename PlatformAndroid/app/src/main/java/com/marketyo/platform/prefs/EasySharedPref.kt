package com.marketyo.platform.prefs

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.marketyo.platform.App

/**
 * Createdby MBH on 18/01/2017.
 */
object EasySharedPref {
    private const val PREF_KEY_SHOP = "shop"
    private const val PREF_KEY_GEOID = "geoid"
    private const val PREF_KEY_SHOP_NAME = "shopname"
    private const val PREF_KEY_GEO_NAME = "geoname"
    private const val PREF_KEY_CITY = "city"
    private const val PREF_KEY_TOKEN = "tkn"
    private const val PREF_KEY_USER_NAME = "un"
    private const val PREF_KEY_USER_PASSWORD = "pwd"
    private const val PREF_KEY_ADDRESS_ID = "adr"
    private const val PREF_KEY_CITY_ID = "cid"
    private const val PREF_KEY_CITY_NAME = "cname"
    private const val PREF_KEY_DIST_ID = "did"
    private const val PREF_KEY_DIST_NAME = "dname"
    private const val PREF_KEY_NEIGHB_ID = "nid"
    private const val PREF_KEY_NEIGHB_NAME = "nname"
    private const val PREF_KEY_WEBSERVICE_LINK = "wlink"
    private const val PREF_KEY_BITARIF = "btrf"
    private const val PREF_KEY_GEONAME_FULL = "geofull"
    private const val PREF_KEY_COMMENCIS_SETUSER = "commencisuserset"


    var isCommencisUserSet: Boolean?
        get() = getBoolean(PREF_KEY_COMMENCIS_SETUSER, false)
        set(value) {
            setBoolean(PREF_KEY_COMMENCIS_SETUSER, value ?: false)
        }

    // region SHOP
    val shop: String?
        get() = getString(PREF_KEY_SHOP, "")

    fun setShop(shop: String) {
        setString(PREF_KEY_SHOP, shop)
    }

    val shopName: String?
        get() = getString(PREF_KEY_SHOP_NAME, "")

    fun setShopName(shopName: String) {
        setString(PREF_KEY_SHOP_NAME, shopName)
    }

    fun setShopIdAndName(
        shopId: String?,
        shopName: String?,
        geoId: String?
    ) {
        defaultSharedPrefs.edit()
            .putString(PREF_KEY_SHOP_NAME, shopName)
            .putString(PREF_KEY_SHOP, shopId)
            .putString(PREF_KEY_GEOID, geoId).commit()
    }

    // endregion
    //region Geo
    val geoId: String?
        get() = getString(PREF_KEY_GEOID, "")

    val geoName: String?
        get() = getString(PREF_KEY_GEO_NAME, "")

    fun setGeoIdAndName(shopId: String?, shopName: String?) {
        defaultSharedPrefs.edit()
            .putString(PREF_KEY_GEO_NAME, shopName)
            .putString(PREF_KEY_GEOID, shopId).commit()
    }

    fun setFullGeoName(geoName: String?) {
        defaultSharedPrefs.edit()
            .putString(PREF_KEY_GEONAME_FULL, geoName).commit()
    }

    val fullGeoName: String?
        get() = getString(PREF_KEY_GEONAME_FULL, "")

    val currentAddressId: String?
        get() = getString(PREF_KEY_ADDRESS_ID, "")

    fun setCurrentAddressId(addressId: String) {
        setString(PREF_KEY_ADDRESS_ID, addressId)
    }

    fun setSelectedPlace(
        cityId: String?,
        cityName: String?,
        distId: String?,
        distName: String?,
        neighbId: String?,
        neighbName: String?
    ) {
        defaultSharedPrefs.edit()
            .putString(PREF_KEY_CITY_ID, cityId)
            .putString(PREF_KEY_CITY_NAME, cityName)
            .putString(PREF_KEY_DIST_ID, distId)
            .putString(PREF_KEY_DIST_NAME, distName)
            .putString(PREF_KEY_NEIGHB_ID, neighbId)
            .putString(PREF_KEY_NEIGHB_NAME, neighbName).commit()
    }

    val cityId: String?
        get() = getString(PREF_KEY_CITY_ID, "")

    val cityName: String?
        get() = getString(PREF_KEY_CITY_NAME, "")

    val distId: String?
        get() = getString(PREF_KEY_DIST_ID, "")

    val distName: String?
        get() = getString(PREF_KEY_DIST_NAME, "")

    val neighbId: String?
        get() = getString(PREF_KEY_NEIGHB_ID, "")

    val neighbName: String?
        get() = getString(PREF_KEY_NEIGHB_NAME, "")

    //endregion

    var isBitarif: Boolean?
        get() = getBoolean(PREF_KEY_BITARIF, false)
        set(value) {
            setBoolean(PREF_KEY_BITARIF, value ?: false)
        }

    // region user info
    @JvmStatic
    val token: String?
        get() = getString(PREF_KEY_TOKEN, "")

    fun setToken(token: String) {
        setString(PREF_KEY_TOKEN, token)
    }

    fun setUserInfo(username: String?, password: String?) {
        defaultSharedPrefs.edit()
            .putString(PREF_KEY_USER_NAME, username)
            .putString(PREF_KEY_USER_PASSWORD, password).apply()
    }

    @JvmStatic
    fun setUserInfoWithToken(
        username: String?,
        password: String?,
        token: String?
    ) {
        defaultSharedPrefs.edit()
            .putString(PREF_KEY_USER_NAME, username)
            .putString(PREF_KEY_USER_PASSWORD, password)
            .putString(PREF_KEY_TOKEN, token).commit()
    }

    val userName: String?
        get() = getString(PREF_KEY_USER_NAME, "")

    val password: String?
        get() = getString(PREF_KEY_USER_PASSWORD, "")

    // endregion
    // region EasyPut EasySet
    private fun setString(key: String, value: String) {
        try {
            defaultSharedPrefs.edit().putString(key, value).apply()
        } catch (ignored: Exception) {
        }
    }

    private fun setBoolean(key: String, value: Boolean) {
        try {
            defaultSharedPrefs.edit().putBoolean(key, value).apply()
        } catch (ignored: Exception) {
        }
    }

    private fun setInt(key: String, value: Int) {
        try {
            defaultSharedPrefs.edit().putInt(key, value).apply()
        } catch (ignored: Exception) {
        }
    }

    private fun getString(key: String, defValue: String): String? {
        return try {
            defaultSharedPrefs.getString(key, defValue)
        } catch (ignored: Exception) {
            defValue
        }
    }

    private fun getBoolean(key: String, defValue: Boolean): Boolean {
        return try {
            defaultSharedPrefs.getBoolean(key, defValue)
        } catch (ignored: Exception) {
            defValue
        }
    }

    private fun getInt(key: String, defValue: Int): Int {
        return try {
            defaultSharedPrefs.getInt(key, defValue)
        } catch (ignored: Exception) {
            defValue
        }
    }

    var customWebserviceLink: String?
        get() = getString(PREF_KEY_WEBSERVICE_LINK, "")
        set(newLink) {
            defaultSharedPrefs.edit()
                .putString(PREF_KEY_WEBSERVICE_LINK, newLink)
                .commit()
        }

    private val defaultSharedPrefs: SharedPreferences
        private get() = PreferenceManager.getDefaultSharedPreferences(App.instance)

    private fun getDefaultSharedPrefs(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    } // endregion
}