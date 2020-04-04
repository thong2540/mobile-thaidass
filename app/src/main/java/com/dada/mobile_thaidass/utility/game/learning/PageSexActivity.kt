package com.dada.mobile_thaidass.utility.game.learning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.model.Content
import com.dada.mobile_thaidass.utility.hideStatusBar
import com.dada.mobile_thaidass.utility.overrideTransitionLeftToRight
import com.dada.mobile_thaidass.utility.overrideTransitionRightToLeft
import kotlinx.android.synthetic.main.activity_page_sex.*

class PageSexActivity : AppCompatActivity() {

    private lateinit var data: Content

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_sex)
        hideStatusBar()

        getData()

        onEvent()
    }

    private fun getData() {
        if (intent == null) return
        val bundle = intent.extras
        data = bundle?.getSerializable("model") as Content

    }

    private fun onEvent() {
        goBack.setOnClickListener { onBackPressed() }
        boy.setOnClickListener { presentPlayLearning("boy") }
        girl.setOnClickListener { presentPlayLearning("girl") }
    }

    private fun presentPlayLearning(six: String) {
        val intent = Intent(this, PlayLearningActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("model", data)
        intent.putExtras(bundle)
        intent.putExtra("six", six)
        startActivity(intent)
        overrideTransitionRightToLeft()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overrideTransitionLeftToRight()
    }
}
