package com.dada.mobile_thaidass.utility.game.quiz_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.utility.AnimationClose
import com.dada.mobile_thaidass.utility.closeActivity
import com.dada.mobile_thaidass.utility.overrideTransitionLeftToRight
import com.dada.mobile_thaidass.utility.overrideTransitionRightToLeft
import com.dada.mobile_thaidass.utility.hideStatusBar
import kotlinx.android.synthetic.main.activity_home_quiz_game.*

class HomeQuizGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_quiz_game)
        hideStatusBar()

        onEvent()
    }

    private fun onEvent() {
        playHome.setOnClickListener {
            val intent = Intent(this,QuizGameActivity::class.java)
            startActivity(intent)
            finish()
            overrideTransitionRightToLeft()
        }

        closeActivity(exitHome, AnimationClose.LEFT_TO_RIGHT)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overrideTransitionLeftToRight()

    }
}
