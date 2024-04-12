package com.example.thiru

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.thiru.databinding.ActivitySideNavbarBinding
import com.google.android.material.navigation.NavigationView

class SideNavbar : AppCompatActivity() {

    private lateinit var sideNavbarBinding: ActivitySideNavbarBinding

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        sideNavbarBinding = ActivitySideNavbarBinding.inflate(layoutInflater)
        setContentView(sideNavbarBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        drawerLayout = sideNavbarBinding.main
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)



        sideNavbarBinding = ActivitySideNavbarBinding.inflate(layoutInflater)
        setContentView(sideNavbarBinding.root)

        val navView: NavigationView = sideNavbarBinding.navView

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        navView.setNavigationItemSelectedListener { menuItem ->
            // Handle navigation view item clicks here.
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    // Replace with logic to navigate to Home fragment or activity
                    replaceFragment(HomeFragment())
                }
                R.id.nav_drives -> {
                    // Replace with logic to navigate to Drives fragment or activity
                    replaceFragment(DrivesFragment())
                }
                R.id.nav_tests -> {
                    // Replace with logic to navigate to Tests fragment or activity
                    replaceFragment(TestsFragment())
                }
                R.id.nav_analysis -> {
                    // Replace with logic to navigate to Analysis fragment or activity
                    replaceFragment(AnalysisFragment())
                }
                R.id.nav_user -> {
                    // Replace with logic to navigate to User fragment or activity
                    replaceFragment(UserFragment())
                }
                R.id.nav_settings -> {
                    // Replace with logic to navigate to Settings fragment or activity
                    replaceFragment(SettingsFragment())
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == android.R.id.home) {
//            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//                drawerLayout.closeDrawer(GravityCompat.START)
//            } else {
//                drawerLayout.openDrawer(GravityCompat.START)
//            }
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }


}


//        replaceFragment(HomeFragment())
//        updateNavigationState(R.id.categories_text)
//
//        sideNavbarBinding.categoriesImage.setOnClickListener {
//            replaceFragment(HomeFragment())
//            updateNavigationState(R.id.categories_text)
//        }
//
//        sideNavbarBinding.drivesImg.setOnClickListener {
//            replaceFragment(DrivesFragment())
//            updateNavigationState(R.id.drivesText)
//        }
//
//        sideNavbarBinding.drivesImg.setOnClickListener {
//            replaceFragment(DrivesFragment())
//            updateNavigationState(R.id.drivesText)
//        }
//
//        sideNavbarBinding.testImg.setOnClickListener {
//            replaceFragment(TestsFragment())
//            updateNavigationState(R.id.testTxt)
//        }
//
//        sideNavbarBinding.analysisImg.setOnClickListener {
//            replaceFragment(AnalysisFragment())
//            updateNavigationState(R.id.analysisTxt)
//        }
//
//        sideNavbarBinding.userImg.setOnClickListener {
//            replaceFragment(UserFragment())
//            updateNavigationState(R.id.userTxt)
//        }
//
//        sideNavbarBinding.settingsImg.setOnClickListener {
//            replaceFragment(SettingsFragment())
//            updateNavigationState(R.id.settingsTxt)
//        }
//
//
//        val mainLayout = findViewById<RelativeLayout>(R.id.main)
//
//        val imageViews = listOf(
//            R.id.categories_image,
//            R.id.drivesImg,
//            R.id.testImg,
//            R.id.analysisImg,
//            R.id.userImg,
//            R.id.settingsImg,
//            R.id.logoutImg
//        )
//
//        val textViewIds = listOf(
//            R.id.categories_text,
//            R.id.drivesText,
//            R.id.testTxt,
//            R.id.analysisTxt,
//            R.id.userTxt,
//            R.id.settingsTxt,
//            R.id.logout
//        )
//
//
//        for (i in imageViews.indices) {
//            val imageView = findViewById<ImageView>(imageViews[i])
//            val textView = findViewById<TextView>(textViewIds[i])
//
//            imageView.setOnLongClickListener {
//                val textView = TextView(this@SideNavbar).apply {
//                    text = textView.text.toString()
//                    textSize = 15f
//                    setTextColor(resources.getColor(android.R.color.white))
//                    setBackgroundResource(R.drawable.bg)
//                    setPadding(25, 25, 25, 25)
//                    layoutParams = LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.WRAP_CONTENT,
//                        LinearLayout.LayoutParams.WRAP_CONTENT
//                    ).apply {
//                        leftMargin = imageView.right + 80
//                        topMargin = imageView.top + 10
//                    }
//                }
//                mainLayout.addView(textView)
//                textView.postDelayed({
//                    mainLayout.removeView(textView)
//                }, 1200)
//                true
//            }
//        }
//    }
//
//    private fun replaceFragment(fragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, fragment)
//            .commit()
//    }
//
//    private fun updateNavigationState(selectedTextViewId: Int) {
//
//        sideNavbarBinding.categoriesText.visibility =
//            if (selectedTextViewId == R.id.categories_text) View.VISIBLE else View.INVISIBLE
//        sideNavbarBinding.drivesText.visibility =
//            if (selectedTextViewId == R.id.drivesText) View.VISIBLE else View.INVISIBLE
//        sideNavbarBinding.testTxt.visibility =
//            if (selectedTextViewId == R.id.testTxt) View.VISIBLE else View.INVISIBLE
//        sideNavbarBinding.analysisTxt.visibility =
//            if (selectedTextViewId == R.id.analysisTxt) View.VISIBLE else View.INVISIBLE
//        sideNavbarBinding.userTxt.visibility =
//            if (selectedTextViewId == R.id.userTxt) View.VISIBLE else View.INVISIBLE
//        sideNavbarBinding.settingsTxt.visibility =
//            if (selectedTextViewId == R.id.settingsTxt) View.VISIBLE else View.INVISIBLE
//
//
//        val resources = resources
//        val padding =
//            if (selectedTextViewId == R.id.categories_image) resources.getDimensionPixelSize(R.dimen.selected_padding) else resources.getDimensionPixelSize(
//                R.dimen.default_padding
//            )
//        sideNavbarBinding.main.setPadding(padding, padding, padding, padding)
//    }
