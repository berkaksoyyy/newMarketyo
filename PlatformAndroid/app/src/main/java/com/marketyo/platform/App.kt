package com.marketyo.platform

//import com.marketyo.platform.root.di.module.AdapterModule
//import com.marketyo.platform.prefs.EasySharedPref
//import com.marketyo.platform.root.di.component.DaggerNetComponent
//import com.marketyo.platform.root.di.component.NetComponent
//import com.marketyo.platform.root.di.module.AppModule
//import com.marketyo.platform.root.di.module.NetModule
//import com.marketyo.platform.root.enums.Constants
//import com.marketyo.platform.root.utils.DateUtils
//import com.marketyo.platform.root.utils.EBNotifDeepLinkProduct
//import com.marketyo.platform.root.utils.EBNotifDeepLinkPromotion
//import com.marketyo.platform.root.utils.EBNotifyDeepLinkRating
//import com.marketyo.platform.root.utils.EventBusUtils
//import com.marketyo.platform.root.utils.FilesUtils
//import com.marketyo.platform.root.utils.fonts.FontsOverride
//import com.marketyo.platform.root.utils.listener.ForegroundBackgroundListener
//import com.marketyo.platform.root.utils.thread.ThreadUtils
//import io.reactivex.plugins.RxJavaPlugins
import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDexApplication
import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustConfig
import com.commencis.appconnect.sdk.AppConnect
import com.commencis.appconnect.sdk.iamessaging.AppConnectInAppMessagingConfig
import com.commencis.appconnect.sdk.notifications.AppConnectNotificationConfig
import com.commencis.appconnect.sdk.util.LogLevel
import com.google.android.gms.analytics.Tracker
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.marketyo.platform.base.constant.Constants
import com.marketyo.platform.base.constant.Constants.WS_BASE_URL
import com.marketyo.platform.prefs.EasySharedPref
import com.marketyo.platform.utils.DateUtils
import com.marketyo.platform.utils.FilesUtils
import com.marketyo.platform.utils.ThreadUtils
import com.marketyo.platform.utils.fonts.FontsOverride
import com.onesignal.OSNotificationOpenedResult
import com.onesignal.OSNotificationReceivedEvent
import com.onesignal.OneSignal
import com.zoho.salesiqembed.ZohoSalesIQ
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import jonathanfinerty.once.Once
import org.json.JSONException
import timber.log.Timber
import timber.log.Timber.DebugTree
import java.util.*
import java.util.concurrent.TimeUnit

class App : MultiDexApplication() {
//    private var mNetComponent: NetComponent? = null
    var firebaseAnalytics: FirebaseAnalytics? = null
        private set
    val appConnect: AppConnect? = null
//    private var appObserver: ForegroundBackgroundListener? = null
    private val appConnectSDK = "f95c2488-8acf-11ea-973f-358ed31468c6"
    private val appConnectLiveSDK = "e84cecb7-8acf-11ea-973f-7910b472239c"
    private val channel_id = "de59e940-b25f-47a5-9a60-71927a569f30"
    private val channel_name = "Marketyo"
    var remoteConfig: FirebaseRemoteConfig? = null
        private set

    override fun onCreate() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())
        super.onCreate()
        instance = this
        Constants.prepareFieldsFromXML(this)
        DateUtils.userLocale = Locale(Constants.CURRENT_LANGUAGE)
        initHilt()
//        initEventBus()
        init()
//        appObserver = ForegroundBackgroundListener()
//        ProcessLifecycleOwner.get()
//            .lifecycle
//            .addObserver(appObserver)
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(!BuildConfig.DEBUG)
        ZohoSalesIQ.init(this, getString(R.string.zohoAppKey), getString(R.string.zohoAccessKey))
        initCheckCache()

//        Thread.setDefaultUncaughtExceptionHandler(new MyDefaultUncaughtExceptionHandler());
        val appToken = "udz4kra6z3sw"
        val environment = AdjustConfig.ENVIRONMENT_PRODUCTION
        val config = AdjustConfig(this, appToken, environment)
        config.setAppSecret(3, 1052936407, 1557247463, 326836476, 1374981798)
        config.setLogLevel(com.adjust.sdk.LogLevel.VERBOSE) // enable all logs
        Adjust.onCreate(config)
        registerActivityLifecycleCallbacks(AdjustLifecycleCallbacks())
    }

//    private fun initEventBus() {
//        EventBusUtils.INSTANCE.installIndex()
//    }

    private fun initHilt() {
        var customLink: String = EasySharedPref.customWebserviceLink ?: ""
        if (customLink.isEmpty()) {
            customLink = WS_BASE_URL
        }

        //TODO: Add Hilt implementation
    }

    private fun init() {
        initFont()
        OneSignal.initWithContext(this)
        OneSignal.setAppId("de59e940-b25f-47a5-9a60-71927a569f30")
        OneSignal.setNotificationWillShowInForegroundHandler { notificationReceivedEvent: OSNotificationReceivedEvent ->
            notificationReceivedEvent.complete(
                notificationReceivedEvent.notification
            )
        }
        OneSignal.setNotificationOpenedHandler { notificationOpenResult: OSNotificationOpenedResult ->
            onNotificationOpened(
                notificationOpenResult
            )
        }

        /*OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .setNotificationOpenedHandler(new OneSignal.NotificationOpenedHandler() {
                    @Override
                    public void notificationOpened(OSNotificationOpenResult result) {
                        onNotificationOpened(result);
                    }
                })
                .init();*/remoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(60)
            .build()
        remoteConfig?.setConfigSettingsAsync(configSettings)
        remoteConfig?.setDefaultsAsync(R.xml.remote_config_defaults)
        Timber.plant(DebugTree())
        Once.initialise(this)
//        if (!BuildConfig.DEBUG) RxJavaPlugins.setErrorHandler { e ->
//            Timber.e(
//                e,
//                "Uncaught Exception"
//            )
//        }
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        createNotificationChannel()
        val appConnectNotificationConfig = AppConnectNotificationConfig()
        appConnectNotificationConfig.defaultNotificationChannelId = channel_id
        appConnectNotificationConfig.defaultNotificationChannelName = channel_name
        appConnectNotificationConfig.smallNotificationIcon = R.mipmap.ic_launcher
        appConnectNotificationConfig.largeNotificationIcon = R.mipmap.ic_launcher
        val inAppConfig = AppConnectInAppMessagingConfig()
        inAppConfig.isEnabled = true
        AppConnect.Builder(this, appConnectLiveSDK)
            .withUrl("https://api.dataroid.com")
            .withNotificationConfig(appConnectNotificationConfig)
            .withInAppMessagingConfig(inAppConfig)
            .build()
        AppConnect.enablePush()
        if (BuildConfig.DEBUG) {
            AppConnect.setLogLevel(LogLevel.DEBUG)
        }
        AppConnect.getInAppMessaging()
            .setOnInAppMessageButtonClickListener { inAppMessage, appConnectButton ->
                Timber.i(
                    "$inAppMessage InAppMsgTest"
                )
            }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            try {
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel = NotificationChannel(channel_id, channel_name, importance)
                val notificationManager = getSystemService(
                    NotificationManager::class.java
                )
                notificationManager.createNotificationChannel(channel)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    private fun onNotificationOpened(notificationOpenResult: OSNotificationOpenedResult) {
        if (notificationOpenResult.notification != null && notificationOpenResult.notification.rawPayload != null && notificationOpenResult.notification.additionalData != null) {
            val additionalData = notificationOpenResult.notification.additionalData
            if (additionalData.has("categoryId")) {
                try {
                    val categoryId = additionalData.getString("categoryId")
                    //                    goForCategory(categoryId)
                } catch (e: JSONException) {
                    Timber.e(e)
                }
            } else if (additionalData.has("mcProductId")) {
                try {
                    val productId = additionalData.getString("mcProductId")
                    goForProduct(productId)
                } catch (e: JSONException) {
                    Timber.e(e)
                }
            } else if (additionalData.has("promotionId") || additionalData.has("campaignId")) {
                try {
                    var promotionId = ""
                    if (additionalData.has("promotionId")) promotionId =
                        additionalData.getString("promotionId") else additionalData.getString("campaignId")
                    goForPromotion(promotionId)
                } catch (e: JSONException) {
                    Timber.e(e)
                }
            } else if (additionalData.has("ratingId")) {
                try {
                    val ratingId = additionalData.getString("ratingId")
                    goForRating(ratingId)
                } catch (e: JSONException) {
                    Timber.e(e)
                }
            }
        }
    }

    private fun goForProduct(productId: String) {
//        EventBusUtils.INSTANCE.safePostStikcy(EBNotifDeepLinkProduct(productId))
    }

    private fun goForPromotion(promotionId: String) {
//        EventBusUtils.INSTANCE.safePostStikcy(EBNotifDeepLinkPromotion(promotionId))
    }

    private fun goForRating(ratingLink: String) {
//        EventBusUtils.INSTANCE.safePostStikcy(EBNotifyDeepLinkRating(ratingLink))
    }

    private fun initFont() {
        val appFontNameWithExtension = getString(R.string.app_font_with_extension)
        val appFontNameWithPath = "fonts/$appFontNameWithExtension"

        // To change the font of the whole app
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath(appFontNameWithPath)
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )
        FontsOverride.setDefaultFont(this, "SANS_SERIF", appFontNameWithPath)
        FontsOverride.setDefaultFont(this, "SANS", appFontNameWithPath)
        FontsOverride.setDefaultFont(this, "DEFAULT", appFontNameWithPath)
        FontsOverride.setDefaultFont(this, "SERIF", appFontNameWithPath)
        FontsOverride.setDefaultFont(this, "MONOSPACE", appFontNameWithPath)
    }

    private fun initCheckCache() {
        try {
            if (!Once.beenDone(TimeUnit.MINUTES, 30, "ClearingCache")) {
                Once.markDone("ClearingCache")
                ThreadUtils.fireNForget { FilesUtils.deleteDirectoryTree(applicationContext.cacheDir) }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    enum class TrackerName {
        GLOBAL_TRACKER,  // Tracker used by all the apps from a company. eg: roll-up tracking.
        ECOMMERCE_TRACKER
        // Tracker used by all ecommerce transactions from a company.
    }

    var mTrackers = HashMap<TrackerName, Tracker>()

    private class AdjustLifecycleCallbacks : ActivityLifecycleCallbacks {
        override fun onActivityPreCreated(activity: Activity, savedInstanceState: Bundle?) {}
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
        override fun onActivityPostCreated(activity: Activity, savedInstanceState: Bundle?) {}
        override fun onActivityPreStarted(activity: Activity) {}
        override fun onActivityStarted(activity: Activity) {}
        override fun onActivityPostStarted(activity: Activity) {}
        override fun onActivityPreResumed(activity: Activity) {}
        override fun onActivityResumed(activity: Activity) {
            Adjust.onResume()
        }

        override fun onActivityPostResumed(activity: Activity) {}
        override fun onActivityPrePaused(activity: Activity) {}
        override fun onActivityPaused(activity: Activity) {
            Adjust.onPause()
        }

        override fun onActivityPostPaused(activity: Activity) {}
        override fun onActivityPreStopped(activity: Activity) {}
        override fun onActivityStopped(activity: Activity) {}
        override fun onActivityPostStopped(activity: Activity) {}
        override fun onActivityPreSaveInstanceState(activity: Activity, outState: Bundle) {}
        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
        override fun onActivityPostSaveInstanceState(activity: Activity, outState: Bundle) {}
        override fun onActivityPreDestroyed(activity: Activity) {}
        override fun onActivityDestroyed(activity: Activity) {}
        override fun onActivityPostDestroyed(activity: Activity) {} //...
    } //    synchronized public Tracker getDefaultTracker(TrackerName trackerId) {

    //        if (!mTrackers.containsKey(trackerId)) {
    //
    //            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
    //            Tracker t = (trackerId == TrackerName.GLOBAL_TRACKER) ? analytics.newTracker(R.xml.global_tracker)
    //                    : analytics.newTracker(R.xml.ecommerce_tracker);
    //            mTrackers.put(trackerId, t);
    //
    //        }
    //
    //        return mTrackers.get(trackerId);
    //    }
    companion object {
        var instance: App? = null
            private set

        fun fbAnalytics(): FirebaseAnalytics? {
            return instance!!.firebaseAnalytics
        }

        fun appConnect(): AppConnect? {
            return instance!!.appConnect
        }
    }
}

