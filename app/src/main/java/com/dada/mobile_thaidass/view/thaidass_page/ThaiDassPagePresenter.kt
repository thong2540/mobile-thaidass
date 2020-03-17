package com.dada.mobile_thaidass.view.thaidass_page

import android.util.Log
import com.dada.mobile_thaidass.model.ThaiDassPage
import com.google.firebase.database.*

class ThaiDassPagePresenter(private val view: ThaiDassPageView) {

    private var databaseReference: DatabaseReference? = null
    private var part: ThaiDassPage? = null
    private var listPart = arrayListOf<ThaiDassPage>()

    init {
        databaseReference = FirebaseDatabase.getInstance().getReference("DressPage")
    }

    fun getDressPage(){
        databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                for (snapshot in p0.children) {
                    part = snapshot.getValue(ThaiDassPage::class.java)
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
