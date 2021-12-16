package com.va.nagwatask.presentationlayer

import android.content.Context
import com.va.nagwatask.datalayer.Attachment
import com.va.nagwatask.datalayer.AttachmentsParser
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class AttachmentsViewModel {
    fun getAttachments(context: Context):List<Attachment>{
        val json: String? = try {
            val fileInputStream: InputStream = context.assets.open("getListOfFilesResponse.json")
            val size: Int = fileInputStream.available()
            val buffer = ByteArray(size)
            fileInputStream.read(buffer)
            fileInputStream.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ArrayList()
        }
        return AttachmentsParser.parse(json!!)
    }
}