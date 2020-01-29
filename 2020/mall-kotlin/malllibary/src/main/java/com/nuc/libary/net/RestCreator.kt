package com.nuc.libary.net

import com.nuc.libary.global.GlobalKeys
import com.nuc.libary.global.Mall
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 实利
 * */
class RestCreator {

    /**
     * 构建okhttp
     * */
    private object OkHttpHolder {
        private const val TIME_OUT = 60
        private val BUILDER = OkHttpClient.Builder()
        internal val OK_HTTP_CLIENT = BUILDER
            .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .build()
    }

    private object RetrofitHolder {
        private val BASE_URL =
            Mall.getConfiguration<String>(GlobalKeys.API_HOST)
        internal val RETROFIT_CLIENT =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
    }

    private object RestServiceHolder {
        internal val REST_SERVICE =
            RetrofitHolder
                .RETROFIT_CLIENT
                .create(RestService::class.java)
    }

    val restService: RestService
        get() = RestServiceHolder.REST_SERVICE

}