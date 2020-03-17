package com.dada.mobile_thaidass.view.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.model.BookRespone
import com.dada.mobile_thaidass.view.book.adapter.BookAdapter
import kotlinx.android.synthetic.main.fragment_book.*
import kotlinx.android.synthetic.main.fragment_book.view.*

class BookFragment : Fragment(), BookView {

    private val bookAdapter = BookAdapter()
    private val presenter = BookPresenter(this)

    override fun updateUI(`object`: Any) {
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

        presenter.getListBook()

        setupRecyclerView(view)

        return view
    }

    private fun setupRecyclerView(view: View) {
        view.mainRecyclerBook.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = bookAdapter
        }

    }

}
