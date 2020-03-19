package com.dada.mobile_thaidass.view.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.model.Content
import com.dada.mobile_thaidass.utility.hideStatusBar
import kotlinx.android.synthetic.main.activity_play_learning.*

class PlayLearningActivity : AppCompatActivity() {

    private lateinit var data: Content
    private var six = ""
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_learning)
        hideStatusBar()

        setData()

        onEvent()

    }

    private fun setData() {
        if (intent == null) return
        val bundle = intent.extras
        data = bundle?.getSerializable("model") as Content
        six = intent.getStringExtra("six")

        inItView(index)
    }

    private fun onEvent() {
        goBack.setOnClickListener { finish() }

        left.setOnClickListener {
            if (index > 0) {
                index--
                inItView(index)
            }
        }
        right.setOnClickListener {
            if (six == "boy") {
                if (index < data.itemBoy.icon.size-1) {
                    index++
                    inItView(index)
                }
            } else if (six == "girl") {
                if (index < data.itemWoMen.icon.size-1) {
                    index++
                    inItView(index)
                }
            }
        }
    }

    private fun inItView(index: Int) {
        textTitle.text = data.title
        if (six == "boy") {
            content.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    data.itemBoy.icon[index].icon
                )
            )
            dress.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    data.itemBoy.content[index].content
                )
            )

        } else {
            content.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    data.itemWoMen.icon[index].icon
                )
            )
            dress.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    data.itemWoMen.content[index].content
                )
            )

        }
    }
}
