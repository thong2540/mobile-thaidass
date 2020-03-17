package com.dada.mobile_thaidass.view.gallery.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.model.ContentImage

class GalleryAdapter : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    var itemList: List<ContentImage> = arrayListOf()

    lateinit var callBack: (ContentImage) -> Unit

    fun setOnClickRecyclerViewListener(callBack: (position: ContentImage) -> Unit) {
        this.callBack = callBack
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        val width: Int = Resources.getSystem().displayMetrics.widthPixels

        Glide
            .with(holder.itemView.context)
            .load(item.part)
            .override(width/3,width/3)
            .into(holder.imgAllDass)

        holder.itemView.setOnClickListener {
            callBack.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgAllDass: ImageView = view.findViewById(R.id.imgAllDass)
    }
}