package com.dada.mobile_thaidass.utility.game.quiz_game

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.dada.mobile_thaidass.R

class QuizAdapter : RecyclerView.Adapter<QuizAdapter.ViewHolder>() {

    var itemList: ArrayList<ModelQuiz> = arrayListOf()

    lateinit var callBack: (ItemShow) -> Unit

    fun setOnClickRecyclerViewListener(callBack: (position: ItemShow) -> Unit) {
        this.callBack = callBack
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_quiz, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        val width: Int = (Resources.getSystem().displayMetrics.widthPixels/5)-16
        val param = LinearLayout.LayoutParams(
            width,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        holder.frame.layoutParams = param

        holder.imageQuiz.setImageDrawable(
            ContextCompat.getDrawable(
                holder.itemView.context,
                item.icon
            )
        )

        holder.itemView.setOnClickListener {
            callBack.invoke(ItemShow(position,item))
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageQuiz: ImageView = view.findViewById(R.id.imageQuiz)
        var frame: LinearLayout = view.findViewById(R.id.frame)
    }

    data class ItemShow(
        val position: Int,
        val data: ModelQuiz
    )
}