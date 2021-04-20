package com.captaindeer.myinstagram.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.captaindeer.myinstagram.R
import com.captaindeer.myinstagram.ui.home.HomeFragment
import com.captaindeer.myinstagram.ui.user.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit

class MainActivity : AppCompatActivity(),MainInterface.View, BottomNavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        changeFragment(HomeFragment())

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mni_home -> {
                changeFragment(HomeFragment())
            }

            R.id.mni_empty -> {}
            R.id.mni_empty2 -> {}
            R.id.mni_empty3 -> {}
        }
        return true
    }

    override fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            FragmentTransaction.TRANSIT_FRAGMENT_OPEN
            replace(R.id.fl_main, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}