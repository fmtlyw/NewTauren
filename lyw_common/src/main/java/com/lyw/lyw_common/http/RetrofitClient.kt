package com.lyw.lyw_common.http

import android.util.Log
import com.lyw.lyw_common.BuildConfig
import com.lyw.lyw_common.global.ConfigKeys
import com.lyw.lyw_common.global.Configurator
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 功能描述:静态内部类方式实现单列模式
 * Created on 2021/4/13.
 * @author lyw
 */

//private constructor()私有构造方法
class RetrofitClient private constructor() {
    private val TAG = RetrofitClient::class.java.simpleName


    companion object {
        val instances = SingleTonProvider.holder
    }

    private object SingleTonProvider {
        val holder = RetrofitClient()
    }

    private val httpLoggingInterceptor =
        HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.e(TAG, message)
            }
        }).also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }

    private val okHttpClient = OkHttpClient.Builder().also {
        if (BuildConfig.DEBUG) {
            it.addInterceptor(httpLoggingInterceptor)
        }
        it.apply {
            //超时时间 连接、读、写
            connectTimeout(10, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
            writeTimeout(5, TimeUnit.SECONDS)
        }

    }.build()


    private val retrofit = Retrofit.Builder()
        .baseUrl(Configurator.instance.getConfiguration<String>(ConfigKeys.WEB_API_HOST))
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}