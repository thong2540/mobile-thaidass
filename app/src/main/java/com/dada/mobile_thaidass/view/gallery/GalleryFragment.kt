package com.dada.mobile_thaidass.view.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.model.ContentImage
import com.dada.mobile_thaidass.utility.progassBar
import com.dada.mobile_thaidass.view.gallery.adapter.GalleryAdapter
import com.dada.mobile_thaidass.view.present_Image.PresentImageActivity
import com.kaopiz.kprogresshud.KProgressHUD
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.fragment_gallery.view.*

class GalleryFragment : Fragment(), GalleryView {

    private val galleryAdapter = GalleryAdapter()
    private val presenter = GalleryPresenter(this)
    private var showProgress: KProgressHUD? = null

    override fun updateUI(`object`: Any) {
        showProgress?.dismiss()
        val model = `object` as List<ContentImage>
        galleryAdapter.apply {
            itemList = model
            notifyDataSetChanged()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)
        showProgress = progassBar()
        showProgress?.show()
        presenter.getListImage()

        setupRecyclerView(view)

        onEvent(view)

        return view
    }

    private fun setupRecyclerView(view: View) {
        view.mainRecyclerGallery.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = galleryAdapter
        }
    }

    private fun onEvent(view: View) {
        galleryAdapter.setOnClickRecyclerViewListener {
            val intent = Intent(context, PresentImageActivity::class.java)
            intent.putExtra("part",it.part)
            intent.putExtra("name",it.nameimage)
            startActivity(intent)
        }

    }

}
