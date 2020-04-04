package com.dada.mobile_thaidass.utility.game.choosing_dress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.utility.hideStatusBar
import com.dada.mobile_thaidass.utility.overrideTransitionLeftToRight
import kotlinx.android.synthetic.main.activity_choosing_dress.*

class ChoosingDressActivity : AppCompatActivity() {

    private val presenter = ChoosingDressPresenter()
    private var checkSex = true
    private var positionBoy = 0
    private var positionFemale = 0
    private var shirtId = 0
    private var pantsId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choosing_dress)
        hideStatusBar()

        setUpGame()

        initView()

        onEvent()
    }

    private fun setUpGame() {
        positionBoy = 0
        positionFemale = 0
        checkSex = true
        boy.visibility = View.VISIBLE
        girl.visibility = View.GONE
        setQuiz()
    }

    private fun initView() {
        if (checkSex) {
            // โชว์โจทย์
            if (presenter.quizBoy[positionBoy].shirtId == shirtId && presenter.quizBoy[positionBoy].pantsId == pantsId) {
                if (positionBoy < presenter.quizBoy.size - 1) positionBoy++ else positionBoy = 0
                imageSelectShow.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        presenter.quizBoy[positionBoy].show
                    )
                )
            }
            imageSelectShow.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    presenter.quizBoy[positionBoy].show
                )
            )
        } else {
            if (presenter.quizFemale[positionFemale].shirtId == shirtId && presenter.quizFemale[positionFemale].pantsId == pantsId) {
                if (positionFemale < presenter.quizFemale.size - 1) positionFemale++ else positionFemale = 0
                imageSelectShow.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        presenter.quizFemale[positionFemale].show
                    )
                )
            }
            imageSelectShow.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    presenter.quizFemale[positionFemale].show
                )
            )
        }
    }

    private fun onEvent() {
        btnHome.setOnClickListener { onBackPressed() }
        btn_back.setOnClickListener {
            boy.visibility = View.VISIBLE
            girl.visibility = View.GONE
            ss.visibility = View.GONE
            bt.visibility = View.GONE
            positionBoy = 0
            positionFemale = 0
            shirtId = 0
            pantsId = 0
            // true ผู้ชาย
            checkSex = true
            initView()
            setQuiz()
        }
        btn_next.setOnClickListener {
            girl.visibility = View.VISIBLE
            boy.visibility = View.GONE
            ss.visibility = View.GONE
            bt.visibility = View.GONE
            positionBoy = 0
            positionFemale = 0
            shirtId = 0
            pantsId = 0
            // false ผู้หญิง
            checkSex = false
            initView()
            setQuiz()
        }
        for (i in getButtonShirt().indices) {
            getButtonShirt()[i].setOnClickListener {
                ss.visibility = View.VISIBLE
                ss.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        if (checkSex) presenter.shirtBoy[i].dressSelect else presenter.shirtFemale[i].dressSelect
                    )
                )
                shirtId = if (checkSex) presenter.shirtBoy[i].id else presenter.shirtFemale[i].id
                initView()
            }
        }
        for (i in getButtonPants().indices) {
            getButtonPants()[i].setOnClickListener {
                bt.visibility = View.VISIBLE
                bt.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        if (checkSex) presenter.pantsBoy[i].dressSelect else presenter.pantsFemale[i].dressSelect
                    )
                )
                pantsId = if (checkSex) presenter.pantsBoy[i].id else presenter.pantsFemale[i].id
                initView()
            }
        }
    }

    private fun setQuiz() {
        if (checkSex) {
            // ผู้ชาย
            for (i in getButtonShirt().indices) {
                getButtonShirt()[i].setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        presenter.shirtBoy[i].dress
                    )
                )
            }
            for (i in getButtonPants().indices) {
                getButtonPants()[i].setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        presenter.pantsBoy[i].dress
                    )
                )
            }
        } else {
            // ผู้หญิง
            for (i in getButtonShirt().indices) {
                getButtonShirt()[i].setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        presenter.shirtFemale[i].dress
                    )
                )
            }
            for (i in getButtonPants().indices) {
                getButtonPants()[i].setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        presenter.pantsFemale[i].dress
                    )
                )
            }
        }
    }

    private fun getButtonShirt() = arrayOf(
        ss1,
        ss2,
        ss3,
        ss4,
        ss5
    )

    private fun getButtonPants() = arrayOf(
        bt1,
        bt2,
        bt3,
        bt4,
        bt5
    )

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, HomeChoosingDressActivity::class.java)
        startActivity(intent)
        finish()
        overrideTransitionLeftToRight()
    }
}
