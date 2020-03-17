package com.dada.mobile_thaidass.view.thaidass_page.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.model.ThaiDassPage

class ThaiDassAdapter : RecyclerView.Adapter<ThaiDassAdapter.ViewHolder>() {
    var itemList: List<ThaiDassPage> = arrayListOf()

    lateinit var callBack: (ThaiDassPage) -> Unit

    fun setOnClickRecyclerViewListener(callBack: (position: ThaiDassPage) -> Unit) {
        this.callBack = callBack
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_thai_dass_page, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        Glide
            .with(holder.itemView.context)
            .load(item.imagedress)
            .into(holder.imageDassTitle)

        holder.textDassTitle.text = item.namedress

        holder.textDassTitle.setOnClickListener {
            callBack.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageDassTitle: ImageView = view.findViewById(R.id.imageDassTitle)
        var textDassTitle: TextView = view.findViewById(R.id.textDassTitle)

    }
}