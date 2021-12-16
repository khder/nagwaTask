package com.va.nagwatask.uiLayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.va.nagwatask.R
import com.va.nagwatask.datalayer.Attachment
import com.va.nagwatask.presentationlayer.AttachmentsViewModel

class AttachmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attachments)
        findViewById<RecyclerView>(R.id.attachments_list).adapter =
                AttachmentsListAdapter(AttachmentsViewModel().getAttachments(this))
    }
}