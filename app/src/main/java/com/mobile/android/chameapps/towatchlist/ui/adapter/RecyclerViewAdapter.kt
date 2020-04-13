package com.mobile.android.chameapps.towatchlist.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.android.chameapps.towatchlist.R
import com.mobile.android.chameapps.towatchlist.room.entities.Item

class RecyclerViewAdapter(
    var context: Activity,
    var userArrayList: List<Item>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val rootView =
            LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return RecyclerViewViewHolder(rootView)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        val (title) = userArrayList[position]
        val (rating) = userArrayList[position]
        val viewHolder = holder as RecyclerViewViewHolder
        viewHolder.txtView_title.text = title
        viewHolder.txtView_description.text = rating
    }

    override fun getItemCount(): Int {
        return userArrayList.size
    }

    internal inner class RecyclerViewViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var imgView_icon: ImageView
        var txtView_title: TextView
        var txtView_description: TextView

        init {
            imgView_icon = itemView.findViewById(R.id.imgView_icon)
            txtView_title = itemView.findViewById(R.id.txtView_title)
            txtView_description = itemView.findViewById(R.id.txtView_description)
        }
    }
}