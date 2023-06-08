package com.example.apicallingpractise

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationBtn=findViewById<BottomNavigationView>(R.id.navigation_view)
        loadFragment(HomeFragment())
        navigationBtn.setOnItemSelectedListener {
            when (it.itemId){
                R.id.home -> loadFragment(HomeFragment())
                R.id.setting -> loadFragment(SettingFragment())
                R.id.profile -> loadFragment(ProfileFragment())

            }
            true
        }
    }

    private fun loadFragment (fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.framelaout,fragment).commit()
    }
    }
