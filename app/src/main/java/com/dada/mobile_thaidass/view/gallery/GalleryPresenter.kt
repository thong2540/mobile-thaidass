package com.dada.mobile_thaidass.view.gallery

import android.util.Log
import com.dada.mobile_thaidass.model.ContentImage
import com.google.firebase.database.*

class GalleryPresenter(private val view: GalleryView) {

    private var databaseReference: DatabaseReference? = null
    private var part: ContentImage? = null
    private var listPart = arrayListOf<ContentImage>()

    init {
        databaseReference = FirebaseDatabase.getInstance().getReference("Image")
    }

    fun getListImage(){
        databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                for (snapshot in p0.children) {
                    part = snapshot.getValue(ContentImage::class.java)
                    listPart.add(part!!)
                }
                view.updateUI(listPart)
            }

            override fun onCancelled(p0: DatabaseError) {
                Log.e("Error",p0.toException().message.toString())
            }
        })
    }

}
