package com.va.nagwatask.datalayer

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url
import rx.Observable


interface DownloadInterface {
    @Streaming
    @GET
    fun downloadFileByUrl(@Url fileUrl: String?): Observable<Response<ResponseBody?>?>?
}