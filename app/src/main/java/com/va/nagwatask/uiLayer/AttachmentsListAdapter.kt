package com.va.nagwatask.uiLayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.va.nagwatask.R
import com.va.nagwatask.datalayer.Attachment
import org.w3c.dom.Text

class AttachmentsListAdapter(private val attachments: List<Attachment>) : RecyclerView.Adapter<AttachmentsListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameValue: TextView = view.findViewById(R.id.name_value)
        val typeValue:TextView = view.findViewById(R.id.type_value)
        val progressValue:TextView = view.findViewById(R.id.progress_value)
        val circularProgress:CircularProgressIndicator = view.findViewById(R.id.progress_circular)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.attachment_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val attachment = attachments[position]
        holder.nameValue.text = attachment.name
        holder.typeValue.text = attachment.type
    }

    override fun getItemCount(): Int {
        return attachments.size
    }

}