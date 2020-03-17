package com.dada.mobile_thaidass.view.present_Image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.utility.hideStatusBar
import com.dada.mobile_thaidass.utility.makeStatusBarTransparent
import kotlinx.android.synthetic.main.activity_present_image.*

class PresentImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_present_image)
        hideStatusBar()
        if (intent == null) return

        onShowView()
        onEvent()

    }

    private fun onShowView() {
        val  intent = intent
        var name: String = intent.getStringExtra("name")
        Glide.with(this).load(intent.getStringExtra("part")).into(presentImage)
        textViewpresent.text = "รูป $name"
    }

    private fun onEvent() {
        close_image.setOnClickListener {
            finish()
        }
    }
}
