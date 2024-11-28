package com.example.permissions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val contacts: MutableList<ContactModal>) :
    RecyclerView.Adapter<CustomAdapter.ContactViewHolder>() {

    private var onContactClickListener: OnContactClickListener? = null

    interface OnContactClickListener {
        fun onContactClick(contact: ContactModal, position: Int)
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTV: TextView = itemView.findViewById(R.id.nameTV)
        val phoneTV: TextView = itemView.findViewById(R.id.phoneTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun getItemCount() = contacts.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.nameTV.text = contact.name
        holder.phoneTV.text = contact.phone
        holder.itemView.setOnClickListener {
            if (onContactClickListener != null) {
                onContactClickListener!!.onContactClick(contact, position)
            }
        }
    }

    fun setOnContactClickListener(onContactClickListener: OnContactClickListener) {
        this.onContactClickListener = onContactClickListener
    }
}