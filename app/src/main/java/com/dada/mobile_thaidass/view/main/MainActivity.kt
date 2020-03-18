package com.dada.mobile_thaidass.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.dada.mobile_thaidass.R
import com.dada.mobile_thaidass.utility.makeStatusBarTransparent
import com.dada.mobile_thaidass.view.book.BookFragment
import com.dada.mobile_thaidass.view.gallery.GalleryFragment
import com.dada.mobile_thaidass.view.home.HomeFragment
import com.dada.mobile_thaidass.view.thaidass_page.ThaiDassPageFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makeStatusBarTransparent()

        onEvent()

        loadFragment(HomeFragment())

    }

    private fun onEvent() {
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.id_home -> {
                    fragment = HomeFragment()
                    textViewTitle.text = "หน้าแรก"
                }
                R.id.id_activity -> {
                    fragment = BookFragment()
                    textViewTitle.text = "หนังสือ"
                }
                R.id.id_favorites -> {
                    fragment = ThaiDassPageFragment()
                    textViewTitle.text = "ชุดไทยสำคัญ"
                }
                R.id.id_settings -> {
                    fragment = GalleryFragment()
                    textViewTitle.text = "แกลลอรี่"
                }
            }
            loadFragment(fragment)
        }

        learning.setOnClickListener {

        }

    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, fragment)
                .commit()
            return true
        }
        return false
    }

}
