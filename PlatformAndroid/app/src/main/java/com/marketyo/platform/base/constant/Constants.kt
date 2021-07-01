package com.marketyo.platform.base.constant

import android.content.Context
import com.marketyo.platform.BuildConfig
import com.marketyo.platform.R
import com.marketyo.platform.model.core.c.CAddress
import com.marketyo.platform.model.shop.Shop
import com.marketyo.platform.utils.LocaleUtils

object Constants {
    var COMPANY_PAGE_URL = ""
    var WS_BASE_URL = "" // NewReal
    var WS_BASE_DEV_URL = ""

    //    public static final String WS_BASE_URL = "http://192.168.1.35/EsnafService/v3/mobile/"; // Local
    var GENERAL_POLICY_PAGE_URL = ""
    var SERVICE_POLICY_PAGE_URL = ""
    var MEMBERSHIP_POLICY_PAGE_URL = ""
    var FAQ_PAGE_URL = ""
    var LOGIN_URL = ""
    var CONTACT_US_PAGE_URL = ""
    var IS_BOTTOM_NAV_THEME = false
//    var PAYMENT_PROVIDERS: List<PaymentProvider>? = null
    var IS_BAG_CHANGEABLE = true
    var TIMESLOT_COUNT = 3
    var CURRENT_LANGUAGE = "tr"
    var CURRENT_CURRENCY = "₺"
    var CURRENT_SHOP_ID = ""
    var CURRENT_SHOP_NAME = ""
    var CURRENT_SHOP_LOGO = ""
    var CURRENT_GEO_ID = ""
    var CURRENT_ADDRESS: CAddress? = null
    var MIN_APP_VERSION = -1

    //    public static Shop CURRENT_SHOP = null;
    var SECRET_HEADER = "marketyo"
    var LAST_SECRET_HEADER_DATE: Long = 0
    var WEB_HOST = ""
    var CLIENT_KEY = "platform"
    var SUBCLIENT_KEY = "platform"
    var PROVIDER = "premium"
    var SUBTOKEN = ""
    var MERCHANT_ID = ""
    var SELECTED_SHOP: Shop? = null
    var BITARIF_REFERER = "5123456789"
    var IS_COUPON_ENABLED = true
    var DEF_DEBOUNCE_DELAY = 500L
    var isSetUser = false
    fun prepareFieldsFromXML(context: Context) {
        WS_BASE_URL = context.getString(R.string.ws_base_url)
        WS_BASE_DEV_URL =
            "http://externaldev-env.eba-ejcy5mgt.eu-central-1.elasticbeanstalk.com/api/v1/"
        COMPANY_PAGE_URL = context.getString(R.string.company_page_url)
        SHOW_ADS_EVERY_X_PRODUCT = context.resources.getInteger(R.integer.show_ads_every_x_product)
        CURRENT_LANGUAGE = LocaleUtils.getCurrentLocaleString(context)
        IS_BOTTOM_NAV_THEME = context.resources.getBoolean(R.bool.is_bottom_nav_bar_theme)
        CURRENT_CURRENCY = context.getString(R.string.default_currency)
        DEF_CURRENCY = context.getString(R.string.default_currency)
        IS_HORIZONTAL_CATEGORY_SLIDER_THEME =
            context.resources.getBoolean(R.bool.use_horizontal_category_slider_theme)
        WEB_HOST = context.getString(R.string.applink_host)
    }

    var SHOPPINGLIST_ACTIVATED = true
    var COUPON_ACTIVATED = false
    var PRODUCT_NOTE_ACTIVATED = true
    var CANCEL_ORDER_ACTIVATED = true
    var SHOW_CITY_LABELS_ON_MAIN_PAGE = false
    var SLIDESHOW_CATEGORY_ACTIVATED = true
    var SLIDESHOW_PRODUCT_ACTIVATED = false
    var SHOW_QR_SEARCH = true
    const val SHOW_CART_IN_CHECKOUT_PAGE = false
    const val USER_MALE = 1L
    const val USER_FEMALE = 2L
    var KG_INITIAL_AMOUNT = .5f
    var ADET_INITIAL_AMOUNT = 1f
    var KG_DECREASE_AMOUNT = .1f
    var MIN_CART_KG_AMOUNT = .1f
    var ADET_DECREASE_AMOUNT = 1f
    var MIN_CART_ADET_AMOUNT = 1f
    var ADDRESS_MAX_DEPTH = 0
    var SHOW_ADS_EVERY_X_PRODUCT = 2
    var SHOW_ADS_EVERY_X_PRODUCT_IN_CART = SHOW_ADS_EVERY_X_PRODUCT
    var ADS_PRODUCT_BANNER_SCALE = 5.4
    var ADS_CART_BANNER_SCALE = 4.75
    const val DEF_MIN_MEMBERSHIP_REGISTRATION_AGE = 11
    const val DEF_KG_INITIAL_AMOUNT = .5f
    const val DEF_ADET_INITIAL_AMOUNT = 1f
    const val DEF_KG_DECREASE_AMOUNT = .1f
    const val DEF_MIN_CART_KG_AMOUNT = .1f
    const val DEF_ADET_DECREASE_AMOUNT = 1f
    const val DEF_MIN_CART_ADET_AMOUNT = 1f
    const val DEF_SHOPPINGLIST_ACTIVATED = true
    const val DEF_COUPON_ACTIVATED = false
    const val DEF_PRODUCT_NOTE_ACTIVATED = true
    const val DEF_CANCEL_ORDER_ACTIVATED = true
    const val DEF_SHOW_CITY_LABELS_ON_MAIN_PAGE = false
    const val DEF_SLIDESHOW_CATEGORY_ACTIVATED = true
    const val DEF_SLIDESHOW_PRODUCT_ACTIVATED = false
    const val DEF_SHOW_QR_SEARCH = false
    var DEF_CURRENCY = "$"
    const val MIN_MEMBERSHIP_REGISTRATION_AGE = 11
    const val SERVICE_FEE = 3f
    const val DEFAULT_INGREDIENT_POSTION_AMOUNT = 4
    const val DEFAULT_MIN_ORDER_LIMIT = 50
    const val DEFAULT_MIN_FREE_SERVICE_LIMIT = 100
    const val DEFAULT_RULES_DISCOUNT = 0f
    const val MIN_ORDER_LIMIT = 1 // IF sent 0 this will be used
    const val CAMPAIGN_CATEGORY_ID = "426"
    val LOG_RETROFIT_REQUESTS_RESPONSE = BuildConfig.DEBUG
    var IS_HORIZONTAL_CATEGORY_SLIDER_THEME = false
    var IS_SLIDER_CATEGORY_THEME = false
    const val PHONE_NUMBER_DIGITS = "1234567890() "
    const val PHONE_NUMBER_MASK = "([000]) [000] [00] [00]"
}
