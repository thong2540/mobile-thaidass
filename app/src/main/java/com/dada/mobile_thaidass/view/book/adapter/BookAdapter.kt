package com.dada.mobile_thaidass.view.book.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.model.BookRespone

class BookAdapter : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    var itemList: List<BookRespone> = arrayListOf()

    lateinit var callBack: (BookRespone) -> Unit

    fun setOnClickRecyclerViewListener(callBack: (position: BookRespone) -> Unit) {
        this.callBack = callBack
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        Glide
            .with(holder.itemView.context)
            .load(item.imagebook)
            .into(holder.imgBook)

        holder.itemView.setOnClickListener {
            callBack.invoke(item)
        }

        holder.textViewBook.text = item.namebook
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgBook: ImageView = view.findViewById(R.id.imgBook)
        var textViewBook: TextView = view.findViewById(R.id.textViewBook)
    }

}