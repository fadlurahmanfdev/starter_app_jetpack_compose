package com.fadlurahmanf.starterappcompose.core.network.others

import com.fadlurahmanf.starterappcompose.BuildConfig
import com.fadlurahmanf.starterappcompose.core.network.api.IdentityApi
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtilities {
    private val merchantBaseUrl = BuildConfig.BASE_MERCHANT_URL

    fun okHttpClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }

    fun createGuestIdentityNetwork(okHttpClient: OkHttpClient): IdentityApi {
        return Retrofit.Builder().baseUrl("${merchantBaseUrl}/identity-service/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(IdentityApi::class.java)
    }
}