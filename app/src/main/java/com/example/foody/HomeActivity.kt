package com.example.foody

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_main.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var homeFragment: HomeFragment
    lateinit var profileFragment: ProfileFragment
    lateinit var logoutf: Logout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val i = intent.extras

        var hname = i?.get("name")
         var hpass = i?.get("password")
        var hid = i?.get("mobilenumber")

        Log.i("RRRRRRRRRRRRRRRRR","wwwwwwwwwwwwwwwwww")

        Log.i("Name at home", hname as String)
        Log.i("Pass at home", hpass as String)
        Log.i("Id at Home",hid as String)



        setSupportActionBar(tool)
        val actionBar = supportActionBar
        actionBar?.title= "Kotlin project"

        val drawerToggle: ActionBarDrawerToggle = object  : ActionBarDrawerToggle(
            this,drawer,tool,R.string.open,R.string.close
        ){

        }
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navigation.setNavigationItemSelectedListener(this)
        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frame,homeFragment).setTransition(
            FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
    }

    override fun onNavigationItemSelected(menuitem: MenuItem): Boolean {
        when(menuitem.itemId){
            R.id.home -> {
                supportFragmentManager.beginTransaction().replace(R.id.frame,homeFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.profile -> {
                profileFragment = ProfileFragment()

                supportFragmentManager.beginTransaction().replace(R.id.frame,profileFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.logout ->{
                logoutf = Logout()
                supportFragmentManager.beginTransaction().replace(R.id.frame,logoutf).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}