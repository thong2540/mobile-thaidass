package com.dada.mobile_thaidass.view.book

import android.util.Log
import com.dada.mobile_thaidass.model.BookRespone
import com.google.firebase.database.*

class BookPresenter(private val view: BookView) {

    private var databaseReference: DatabaseReference? = null
    private var part: BookRespone? = null
    private var listPart = arrayListOf<BookRespone>()

    init {
        databaseReference = FirebaseDatabase.getInstance().getReference("BookPage")
    }

    fun getListBook(){
        databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                for (snapshot in p0.children) {
                    part = snapshot.getValue(BookRespone::class.java)
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
