package com.marketyo.platform.di.module

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.marketyo.platform.BuildConfig
import com.marketyo.platform.api.MarketyoCoreWS
import com.marketyo.platform.base.constant.Constants
import com.marketyo.platform.utils.helper.LoginHelper
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)
object NetModule {
    @Provides
    fun provideOkHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setLenient()
        return gsonBuilder.create()
    }

    @Provides
    fun providesOkHttpClientBuilder(): OkHttpClient.Builder {
        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.connectTimeout(1, TimeUnit.MINUTES)
        httpClientBuilder.readTimeout(1, TimeUnit.MINUTES)
        httpClientBuilder.writeTimeout(1, TimeUnit.MINUTES)

        // add logging as last interceptor
        if (BuildConfig.DEBUG) {
            httpClientBuilder.addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
        }
        httpClientBuilder.addInterceptor { chain ->
            var userAgentOrigin: String? = ""
            userAgentOrigin = if (System.getProperty("http.agent") == null) {
                ""
            } else {
                System.getProperty("http.agent")
            }
            val userAgent =
                "marketyo/mobile (android/" + Constants.CLIENT_KEY + "/" + BuildConfig.VERSION_NAME + ")"
            Timber.i("SUBCLIENT_KEY " + Constants.SUBCLIENT_KEY)
            val original = chain.request()
            val builder: Request.Builder = original.newBuilder()
            builder.addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("os", "android")
                .addHeader("ui-version", "1")
                .addHeader("lng", Constants.CURRENT_LANGUAGE)
                .addHeader("version", BuildConfig.VERSION_CODE.toString() + "")
                .addHeader("client", Constants.CLIENT_KEY)
                .addHeader("subClient", Constants.SUBCLIENT_KEY)
                .addHeader("provider", Constants.PROVIDER)
                .addHeader("shopId", Constants.CURRENT_SHOP_ID)
                .addHeader("User-Agent-Origin", userAgentOrigin ?: "")
                .addHeader("User-Agent", userAgent)
                .method(original.method, original.body)
            if (LoginHelper.isUserLoggedIn()) {
                builder.addHeader("Authorization", "Bearer " + LoginHelper.token())
                    .addHeader("subToken", "Bearer " + Constants.SUBTOKEN)
            }
            if (BuildConfig.DEBUG) {
                Timber.i("Token: Bearer " + LoginHelper.token())
                Timber.i("ShopId : " + Constants.CURRENT_SHOP_ID)
                Timber.i("SubToken : " + Constants.SUBTOKEN)
                Timber.i("Client : " + Constants.CLIENT_KEY)
                Timber.i("SubClient : " + Constants.SUBCLIENT_KEY)
                Timber.i("Provider : " + Constants.PROVIDER)
            }
            if (Constants.LAST_SECRET_HEADER_DATE > 0) {
                val difference = System.currentTimeMillis() - Constants.LAST_SECRET_HEADER_DATE
                if (difference <= 3600000) { // in less than an hour
                    builder.addHeader("debug", Constants.SECRET_HEADER)
                } else {
                    Constants.LAST_SECRET_HEADER_DATE = 0
                }
            }
            val request: Request = builder.build()
            val response = chain.proceed(request)
            if (response.code == 401) {
                LoginHelper.logout()
                /*EventBusUtils.INSTANCE.safePost(new EBShowServiceError(original.url().url().toString() + "\nBu da Headers Beyza.." + request.headers().toString()));*/
            } else if (response.code == 502) {
//                EventBusUtils.INSTANCE.safePost(new EBShowServiceError("502"));
            } else if (response.code == 504) {
//                EventBusUtils.INSTANCE.safePost(new EBShowServiceError("504"));
            }
            response
        }
        return httpClientBuilder
    }

    @Provides
    fun providesOkHttpClient(builder: OkHttpClient.Builder, okHttpCache: Cache?): OkHttpClient {
        builder.cache(okHttpCache)
        return builder.build()
    }

    @Provides
    fun provideGsonConverter(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun provideRetrofit(converter: Converter.Factory?, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.WS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideMarketyoCoreWS(retrofit: Retrofit): MarketyoCoreWS {
        return retrofit.create(MarketyoCoreWS::class.java)
    }
}