package com.dada.mobile_thaidass.utility

import android.app.Activity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dada.mobile_thaidass.R

enum class AnimationClose {
    LEFT_TO_RIGHT,
    RIGHT_TO_LEFT,
    BOTTOM_TO_TOP,
    TOP_TO_BOTTOM
}

fun Activity.overrideTransitionRightToLeft() {
    this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
}

fun Activity.overrideTransitionLeftToRight() {
    this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
}

fun Activity.overrideTransitionBottomToTop() {
    this.overridePendingTransition(R.anim.slide_up, R.anim.no_animation)
}

fun Activity.overrideTransitionTopToBottom() {
    this.overridePendingTransition(R.anim.no_animation, R.anim.slide_down)
}

fun Activity.closeActivity(view: View, animation: AnimationClose? = null) {
    view.setOnClickListener {
        finish()
        when (animation) {
            AnimationClose.LEFT_TO_RIGHT -> this.overrideTransitionLeftToRight()
            AnimationClose.RIGHT_TO_LEFT -> this.overrideTransitionRightToLeft()
            AnimationClose.BOTTOM_TO_TOP -> this.overrideTransitionBottomToTop()
            AnimationClose.TOP_TO_BOTTOM -> this.overrideTransitionTopToBottom()
        }
    }
}