package com.dada.mobile_thaidass.view.book

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.model.BookRespone
import com.dada.mobile_thaidass.utility.progassBar
import com.dada.mobile_thaidass.view.book.adapter.BookAdapter
import com.dada.mobile_thaidass.view.select_book.SelectBookActivity
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.fragment_book.*
import kotlinx.android.synthetic.main.fragment_book.view.*

class BookFragment : Fragment(), BookView {

    private val bookAdapter = BookAdapter()
    private val presenter = BookPresenter(this)
    private var showProgress: KProgressHUD? = null

    override fun updateUI(`object`: Any) {
        showProgress?.dismiss()
        val model = `object` as List<BookRespone>
        bookAdapter.apply {
            itemList = model
            notifyDataSetChanged()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book, container, false)
        showProgress = progassBar()
        showProgress?.show()
        presenter.getListBook()

        setupRecyclerView(view)

        onEvent()

        return view
    }

    private fun setupRecyclerView(view: View) {
        view.mainRecyclerBook.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = bookAdapter
        }

    }

    private fun onEvent() {
        bookAdapter.setOnClickRecyclerViewListener {
            val intent = Intent(context, SelectBookActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("data_book",it)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

}
