package com.dada.mobile_thaidass.utility.game.choosing_dress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.utility.*
import kotlinx.android.synthetic.main.activity_home_choosing_dress.*

class HomeChoosingDressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_choosing_dress)
        hideStatusBar()

        onEvent()
    }

    private fun onEvent() {
        playHome.setOnClickListener {
            val intent = Intent(this, ChoosingDressActivity::class.java)
            startActivity(intent)
            finish()
            overrideTransitionRightToLeft()
        }

        closeActivity(exitHome, AnimationClose.LEFT_TO_RIGHT)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overrideTransitionLeftToRight()
    }
}
