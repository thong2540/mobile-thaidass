package com.dada.mobile_thaidass.utility.game.quiz_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.utility.DialogManager
import com.dada.mobile_thaidass.utility.hideStatusBar
import com.dada.mobile_thaidass.utility.overrideTransitionLeftToRight
import kotlinx.android.synthetic.main.activity_quiz_game.*


class QuizGameActivity : AppCompatActivity() {

    private val presenter = QuizGamePresenter()
    private val quizAdapter = QuizAdapter()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val dialog = DialogManager()
    private var dataItem = presenter.setData
    private var position = 0
    private var score = 0
    private var mFirst = 0
    private var mLast = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_game)
        hideStatusBar()

        setRecyclerView()

        initView()

        onEvent()

    }

    private fun initView() {
        val quiz = presenter.quiz
        textViewQuiz.text = quiz[position].title
        textScore.text = "คะแนน : $score"
    }

    private fun setRecyclerView() {
        quizAdapter.itemList = dataItem
        linearLayoutManager =
            LinearLayoutManager(this@QuizGameActivity, RecyclerView.HORIZONTAL, false)
        listQuiz.apply {
            layoutManager = linearLayoutManager
            adapter = quizAdapter
        }

        listQuiz.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val llm = listQuiz.layoutManager as LinearLayoutManager
                mLast = llm.findLastCompletelyVisibleItemPosition()
                mFirst = llm.findFirstCompletelyVisibleItemPosition()
            }
        })
    }

    private fun onEvent() {
        quizAdapter.setOnClickRecyclerViewListener {
            if (it.data.id == presenter.quiz[position].id) {
                score++
                openDialog(true, it.position, "")
            } else {
                openDialog(false, -1, "คุณตอบผิด ต้องการตอบใหม่หรือไม่ ?")
            }
        }
        imageViewBack.setOnClickListener {
            val llm = listQuiz.layoutManager as LinearLayoutManager
            llm.scrollToPositionWithOffset(mFirst - 1, dataItem.size)
        }
        imageViewNext.setOnClickListener {
            val llm = listQuiz.layoutManager as LinearLayoutManager
            llm.scrollToPositionWithOffset(mLast + 1, dataItem.size)
        }
        goHome.setOnClickListener { onBackPressed() }
    }

    private fun openDialog(check: Boolean, index: Int, manager: String) {
        if (check) {
            dialog.alertShow(this, presenter.quiz[position].show)
            dialog.setOnDialogSuccessListener {
                if (it == R.id.textAlertConfirm) {
                    position++
                    quizAdapter.itemList.removeAt(index)
                    quizAdapter.notifyItemRemoved(index)
                    quizAdapter.notifyItemRangeChanged(index, quizAdapter.itemCount)
                    dialog.alertdialog!!.dismiss()
                    if (position == 10) {
                        Handler().postDelayed({
                            check()
                        }, 1000)
                    } else check()
                }
            }
        } else {
            dialog.alertError(this, manager, false)
            dialog.setOnDialogSuccessListener {
                if (it == R.id.textCancel) {
                    position++
                    dialog.alertdialog!!.dismiss()
                    if (position == 10) {
                        Handler().postDelayed({
                            check()
                        }, 1000)
                    } else check()
                }
            }
        }
    }

    private fun check() {
        if (position == 10) {
            dialog.alertError(this, "คุณทำครบ 10 ข้อแล้วได้คะแนนทั้งหมด $score คะแนน", true)
            dialog.setOnDialogSuccessListener {
                if (it == R.id.textConfirm) {
                    onBackPressed()
                }
            }
        } else {
            initView()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, HomeQuizGameActivity::class.java)
        startActivity(intent)
        finish()
        overrideTransitionLeftToRight()
    }
}
