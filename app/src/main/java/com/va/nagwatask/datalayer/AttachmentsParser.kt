package com.va.nagwatask.datalayer

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


object AttachmentsParser {
    fun parse(json: String):List<Attachment>{
        val attachments = ArrayList<Attachment>()
        try {
            val attachmentsJsonArray = JSONArray(json)
            var attachmentJsonObject:JSONObject
            for (i in 0 until attachmentsJsonArray.length()) {
                attachmentJsonObject = attachmentsJsonArray.getJSONObject(i)
                attachments.add(Attachment(attachmentJsonObject.getInt("id"),
                attachmentJsonObject.getString("type"),
                attachmentJsonObject.getString("url"),
                attachmentJsonObject.getString("name")))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return attachments
    }
}