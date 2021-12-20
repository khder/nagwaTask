package com.va.nagwatask.datalayer

import okhttp3.Interceptor
import okhttp3.Response

class DownloadProgressInterceptor(private var progressListener: DownloadProgressListener) : Interceptor {


    override fun intercept(chain: Interceptor.Chain?): Response {
        val originalResponse = chain!!.proceed(chain.request())
        return originalResponse.newBuilder()
            .body(DownloadProgressResponseBody(originalResponse.body(), progressListener))
            .build()

    }
}