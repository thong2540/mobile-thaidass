package com.dada.mobile_thaidass.view.select_book

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.model.BookRespone
import com.dada.mobile_thaidass.utility.makeStatusBarTransparent
import com.dada.mobile_thaidass.view.detail_book.DetailBookActivity
import kotlinx.android.synthetic.main.activity_select_book.*

class SelectBookActivity : AppCompatActivity() {

    private var model : BookRespone? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_book)
        makeStatusBarTransparent()

        inItView()

        onEvent()
    }

    private fun inItView() {
        if (intent == null) return
        val bundle = intent.extras
        model = bundle?.getSerializable("data_book") as BookRespone

        textViewTitle.text = model?.namebook

        Glide
            .with(this)
            .load(model?.imagerama)
            .into(imageSelect)

        textViewTitleSelect.text = "${model?.namecontent} \n (${model?.namebook})"

    }

    private fun onEvent() {
        textViewClose.setOnClickListener {
            finish()
        }

        buttonSelect1.setOnClickListener {
            startDetailBook(model!!,"content")
        }

        buttonSelect2.setOnClickListener {
            startDetailBook(model!!,"dress")
        }

    }

    private fun startDetailBook(data: BookRespone,falg: String){
        val intent = Intent(this, DetailBookActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("data_book",data)
        intent.putExtras(bundle)
        intent.putExtra("falg",falg)
        startActivity(intent)
    }
}
