package com.va.nagwatask.datalayer

import android.os.FileUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import okhttp3.ResponseBody
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.functions.Func1
import rx.schedulers.Schedulers
import java.io.File


class AttachmentsRepository(private val downloadAPI: DownloadAPI) {
    val progressLiveData:MutableLiveData<Download> = MutableLiveData<Download>()
    fun download(url:String,id:Int){
       
    }
}