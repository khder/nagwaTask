package com.va.nagwatask.datalayer

import android.os.FileUtils
import com.va.nagwatask.utils.FileUtils.saveFile
import com.va.nagwatask.utils.FileUtils.writeFile
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.functions.Func1
import rx.schedulers.Schedulers
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.util.concurrent.TimeUnit


class DownloadAPI() {
    lateinit var retrofit:Retrofit
    constructor(url: String, listener: DownloadProgressListener):this() {
        val interceptor = DownloadProgressInterceptor(listener)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .retryOnConnectionFailure(true)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(client)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    }

    fun downloadFile(url: String, file: File?, subscriber: Subscriber<InputStream>?) {
        retrofit.create(DownloadInterface::class.java)
            .downloadFileByUrl(url)
            ?.subscribeOn(Schedulers.io())
            ?.unsubscribeOn(Schedulers.io())
            ?.map { responseBody -> responseBody?.body()?.byteStream() }
            ?.observeOn(Schedulers.computation())
            ?.doOnNext(Action1<Any?> { inputStream ->
                try {
                    FileUtils.saveFile(inputStream, file)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            })
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(subscriber)
    }

}