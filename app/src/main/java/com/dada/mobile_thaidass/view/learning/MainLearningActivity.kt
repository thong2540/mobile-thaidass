package com.dada.mobile_thaidass.view.learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.utility.hideStatusBar
import kotlinx.android.synthetic.main.activity_main_learning.*

class MainLearningActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_learning)
        hideStatusBar()

        onEvent()
    }

    private fun onEvent() {
        play.setOnClickListener {
            val intent = Intent(this,SelectReignActivity::class.java)
            startActivity(intent)
            finish()
        }

        exit.setOnClickListener {
            finish()
        }
    }
}
