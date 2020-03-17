package com.dada.mobile_thaidass.view.thaidass_page

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.model.ThaiDassPage
import com.dada.mobile_thaidass.utility.progassBarPIE
import com.dada.mobile_thaidass.view.detail_dasspage.DetailDassPageActivity
import com.dada.mobile_thaidass.view.thaidass_page.adapter.ThaiDassAdapter
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.fragment_thai_dass_page.view.*

class ThaiDassPageFragment : Fragment(), ThaiDassPageView {

    private val thaiDassAdapter = ThaiDassAdapter()
    private val presenter = ThaiDassPagePresenter(this)
    private var showProgress: KProgressHUD? = null

    override fun updateUI(`object`: Any) {
        showProgress?.dismiss()
        val model = `object` as List<ThaiDassPage>
        thaiDassAdapter.apply {
            itemList = model
            notifyDataSetChanged()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_thai_dass_page, container, false)
        showProgress = progassBarPIE()
        showProgress?.show()

        presenter.getDressPage()

        setupRecyclerView(view)

        onEvent()

        return view
    }

    private fun setupRecyclerView(view: View) {
        view.recyclerViewThaiDassPage.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = thaiDassAdapter
        }
    }

    private fun onEvent() {
        thaiDassAdapter.setOnClickRecyclerViewListener {
            val intent = Intent(context, DetailDassPageActivity::class.java)
            intent.putExtra("part",it.imagepage)
            intent.putExtra("name",it.infodress)
            intent.putExtra("title",it.namepage)
            startActivity(intent)
        }
    }

}
