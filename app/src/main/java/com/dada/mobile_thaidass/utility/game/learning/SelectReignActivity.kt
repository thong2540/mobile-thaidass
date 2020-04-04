package com.dada.mobile_thaidass.utility.game.learning

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.model.*
import com.dada.mobile_thaidass.utility.hideStatusBar
import com.dada.mobile_thaidass.utility.overrideTransitionLeftToRight
import com.dada.mobile_thaidass.utility.overrideTransitionRightToLeft
import kotlinx.android.synthetic.main.activity_select_reign.*


class SelectReignActivity : AppCompatActivity() {

    private var data = arrayListOf<Content>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_reign)
        hideStatusBar()

        setData()

        onEvent()

    }

    private fun onEvent() {
        backToHome.setOnClickListener {onBackPressed()}
        reign1.setOnClickListener { presentPageSex(data[0]) }
        reign4.setOnClickListener { presentPageSex(data[1]) }
        reign5.setOnClickListener { presentPageSex(data[2]) }
        reign6.setOnClickListener { presentPageSex(data[3]) }
        reign7.setOnClickListener { presentPageSex(data[4]) }
        reign8.setOnClickListener { presentPageSex(data[5]) }
        reign9.setOnClickListener { presentPageSex(data[6]) }
    }

    private fun presentPageSex(model: Content) {
        val intent = Intent(this, PageSexActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("model", model)
        intent.putExtras(bundle)
        startActivity(intent)
        overrideTransitionRightToLeft()
    }

    private fun setData() {
        // 1-3
        data.add(
            Content(
                title = "รัชกาลที่ 1-3",
                itemBoy = Six(
                    icon = arrayListOf(LstIcon(icon = R.drawable.b1)),
                    content = arrayListOf(LstContent(content = R.drawable.db1))
                ),
                itemWoMen = Six(
                    icon = arrayListOf(LstIcon(icon = R.drawable.g1)),
                    content = arrayListOf(LstContent(content = R.drawable.dg1))
                )

            )
        )

        // 4
        data.add(
            Content(
                title = "รัชกาลที่ 4",
                itemBoy = Six(
                    icon = arrayListOf(LstIcon(icon = R.drawable.b4)),
                    content = arrayListOf(LstContent(content = R.drawable.db4))
                ),
                itemWoMen = Six(
                    icon = arrayListOf(LstIcon(icon = R.drawable.g4)),
                    content = arrayListOf(LstContent(content = R.drawable.dg4))
                )

            )
        )

        // 5
        data.add(
            Content(
                title = "รัชกาลที่ 5",
                itemBoy = Six(
                    icon = arrayListOf(LstIcon(icon = R.drawable.b5)),
                    content = arrayListOf(LstContent(content = R.drawable.db5))
                ),
                itemWoMen = Six(
                    icon = arrayListOf(LstIcon(icon = R.drawable.g5)),
                    content = arrayListOf(LstContent(content = R.drawable.dg5))
                )

            )
        )

        // 6
        data.add(
            Content(
                title = "รัชกาลที่ 6",
                itemBoy = Six(
                    icon = arrayListOf(LstIcon(icon = R.drawable.b6)),
                    content = arrayListOf(LstContent(content = R.drawable.db6))
                ),
                itemWoMen = Six(
                    icon = arrayListOf(LstIcon(icon = R.drawable.g6)),
                    content = arrayListOf(LstContent(content = R.drawable.dg6))

                )
            )
        )

        // 7
        data.add(
            Content(
                title = "รัชกาลที่ 7",
                itemBoy = Six(
                    icon = arrayListOf(LstIcon(icon = R.drawable.b7)),
                    content = arrayListOf(LstContent(content = R.drawable.db7))
                ),
                itemWoMen = Six(
                    icon = arrayListOf(LstIcon(icon = R.drawable.g6)),
                    content = arrayListOf(LstContent(content = R.drawable.dg7))
                )

            )
        )

        // 8
        data.add(
            Content(
                title = "รัชกาลที่ 8",
                itemBoy = Six(
                    icon = arrayListOf(LstIcon(icon = R.drawable.b8)),
                    content = arrayListOf(LstContent(content = R.drawable.db8))
                ),
                itemWoMen = Six(
                    icon = arrayListOf(LstIcon(icon = R.drawable.g6)),
                    content = arrayListOf(LstContent(content = R.drawable.dg8))

                )
            )
        )

        // 9
        data.add(
            Content(
                title = "รัชกาลที่ 9",
                itemBoy = Six(
                    icon = arrayListOf(LstIcon(icon = R.drawable.b9)),
                    content = arrayListOf(LstContent(content = R.drawable.db9))
                ),
                itemWoMen = Six(
                    icon = arrayListOf(
                        LstIcon(icon = R.drawable.g91),
                        LstIcon(icon = R.drawable.g92),
                        LstIcon(icon = R.drawable.g93),
                        LstIcon(icon = R.drawable.g94),
                        LstIcon(icon = R.drawable.g95),
                        LstIcon(icon = R.drawable.g96),
                        LstIcon(icon = R.drawable.g97),
                        LstIcon(icon = R.drawable.g98)
                    ),
                    content = arrayListOf(
                        LstContent(content = R.drawable.dg91),
                        LstContent(content = R.drawable.dg92),
                        LstContent(content = R.drawable.dg93),
                        LstContent(content = R.drawable.dg94),
                        LstContent(content = R.drawable.dg95),
                        LstContent(content = R.drawable.dg96),
                        LstContent(content = R.drawable.dg97),
                        LstContent(content = R.drawable.dg98)
                    )

                )
            )
        )
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainLearningActivity::class.java)
        startActivity(intent)
        finish()
        overrideTransitionLeftToRight()
    }
}
