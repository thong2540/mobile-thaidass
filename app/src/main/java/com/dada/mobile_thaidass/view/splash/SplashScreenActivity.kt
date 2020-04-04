package com.dada.mobile_thaidass.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.utility.darkenStatusBar
import com.dada.mobile_thaidass.utility.makeStatusBarTransparent
import com.dada.mobile_thaidass.view.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreenActivity : AppCompatActivity() {

    private var handler: Handler? = null
    private var runnable: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        makeStatusBarTransparent()
        handler = Handler()

        setInit()

        startMain()
    }

    private fun setInit() {
        val myanim = AnimationUtils.loadAnimation(this, R.anim.mytra)
        imgLogoAppSplash.startAnimation(myanim)
        text.startAnimation(myanim)
    }

    private fun startMain() {
        runnable = Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    public override fun onResume() {
        super.onResume()
        handler!!.postDelayed(runnable, 3000)
    }

    public override fun onStop() {
        super.onStop()
        handler!!.removeCallbacks(runnable)
    }
}
