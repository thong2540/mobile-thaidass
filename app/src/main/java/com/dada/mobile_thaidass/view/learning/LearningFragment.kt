package com.dada.mobile_thaidass.view.learning

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.utility.game.choosing_dress.HomeChoosingDressActivity
import com.dada.mobile_thaidass.utility.game.learning.MainLearningActivity
import com.dada.mobile_thaidass.utility.game.quiz_game.HomeQuizGameActivity
import com.dada.mobile_thaidass.utility.overrideTransitionRightToLeft
import kotlinx.android.synthetic.main.fragment_learning.view.*


class LearningFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_learning, container, false)

        onEvent(view)

        return view
    }

    private fun onEvent(view: View) {
        view.g1.setOnClickListener {
            val intent = Intent(context, MainLearningActivity::class.java)
            startActivity(intent)
            activity!!.overrideTransitionRightToLeft()
        }
        view.g2.setOnClickListener {
            val intent = Intent(context, HomeQuizGameActivity::class.java)
            startActivity(intent)
            activity!!.overrideTransitionRightToLeft()
        }
        view.g3.setOnClickListener {
            val intent = Intent(context, HomeChoosingDressActivity::class.java)
            startActivity(intent)
            activity!!.overrideTransitionRightToLeft()
        }
        view.info.setOnClickListener {
            val intent = Intent(context, InfoActivity::class.java)
            startActivity(intent)
            activity!!.overrideTransitionRightToLeft()
        }
    }
}
