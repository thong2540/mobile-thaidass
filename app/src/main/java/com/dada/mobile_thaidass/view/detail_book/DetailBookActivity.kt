package com.dada.mobile_thaidass.view.detail_book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.model.BookRespone
import com.dada.mobile_thaidass.utility.makeStatusBarTransparent
import kotlinx.android.synthetic.main.activity_detail_book.*

class DetailBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_book)
        makeStatusBarTransparent()

        inItView()

        onEvent()
    }

    private fun inItView() {
        if (intent == null) return
        val bundle = intent.extras
        val book = bundle?.getSerializable("data_book") as BookRespone
        val FLAG = intent.getStringExtra("falg")!!

        if (FLAG == "content") {
            textViewTitle.text = "เนื้อหา"
            header1.visibility = View.VISIBLE
            header2.visibility = View.GONE

            Glide
                .with(this)
                .load(book.imagecontent)
                .into(imageSelectDetail)

            textViewTitleDetail.text = "${book.namecontent} \n (${book.namebook})"

            textViewDetail.text = book.infocontent

        } else if (FLAG == "dress") {
            textViewTitle.text = "การแต่งกาย"
            header1.visibility = View.GONE
            header2.visibility = View.VISIBLE

            Glide
                .with(this)
                .load(book.imagedress12)
                .into(imageSelectDetail)

            textViewTitleManDetail.text = book.namedress1
            textViewDetailMan.text = book.infodress1
            textViewTitleWoManDetail.text = book.namedress1
            textViewDetailWoMan.text = book.infodress2

        }
    }

    private fun onEvent() {
        textViewClose.setOnClickListener {
            finish()
        }

    }
}
