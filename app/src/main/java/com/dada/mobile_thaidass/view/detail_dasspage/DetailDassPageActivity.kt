package com.dada.mobile_thaidass.view.detail_dasspage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.utility.makeStatusBarTransparent
import kotlinx.android.synthetic.main.activity_detail_dass_page.*

class DetailDassPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_dass_page)
        makeStatusBarTransparent()
        if (intent == null) return

        inItView()

        onEvent()
    }

    private fun inItView() {
        val  intent = intent
        var name: String = intent.getStringExtra("name")
        var title: String = intent.getStringExtra("title")
        textViewTitle.text = title
        Glide.with(this).load(intent.getStringExtra("part")).into(imageViewDetail)
        textDetail.text = name

    }

    private fun onEvent() {
        imageClose.setOnClickListener {
            finish()
        }
    }
}
