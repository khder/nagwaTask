package com.va.nagwatask.utils

import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

object FileUtils {
    fun saveFile(file: File, inputStream: InputStream){
        val buffer = ByteArray(2048)
        var len:Int
        if (!file.exists()) {
            file.mkdirs()
        }
        val fileOutputStream= FileOutputStream(file);

        while (true){
            len=inputStream.read(buffer)
            if(len<0)
                break
            fileOutputStream.write(buffer,0,len);
        }
    }
}