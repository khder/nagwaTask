package com.va.nagwatask.di

import android.app.Application
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory


@Module
class NetModule(private var baseUrl: String) {
    @Provides
    fun provideHttpClient(): OkHttpClient? {
        val client = OkHttpClient.Builder()
        return client.build()
    }


    @Provides
    fun provideRetrofit(client: OkHttpClient?): Retrofit? {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }
}