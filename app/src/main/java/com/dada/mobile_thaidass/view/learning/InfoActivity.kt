package com.dada.mobile_thaidass.view.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.utility.makeStatusBarTransparent
import com.dada.mobile_thaidass.utility.overrideTransitionLeftToRight
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        makeStatusBarTransparent()

        onEvent()
    }

    private fun onEvent() {
        back.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overrideTransitionLeftToRight()
    }
}
