package com.hqapps.dazntestapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hqapps.dazntestapp.R
import com.hqapps.dazntestapp.ui.base.BaseActivity
import com.hqapps.dazntestapp.ui.main.curriculumvitaedetails.CurriculumVitaeDetailsFragment


class MainActivity : BaseActivity() {

    companion object {
        private const val FRAGMENT_BUNDLE_KEY = "FRAGMENT_BUNDLE_KEY"
        private const val CURRENTLY_SELECTED_OPTION_BUNDLE_KEY = "CURRENTLY_SELECTED_OPTION"
    }

    private var content: Fragment? = null
    private var currentItemID =  R.id.navigation_events

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState != null) makeStateRestoration(savedInstanceState)
        else makeScreenInitialization()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        content?.let {
            supportFragmentManager.putFragment(outState, FRAGMENT_BUNDLE_KEY, it)
        }
        outState.putInt(CURRENTLY_SELECTED_OPTION_BUNDLE_KEY, currentItemID)
    }
/*
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        if(currentItemID != item.itemId) {
            currentItemID = item.itemId
            when (item.itemId) {
                R.id.navigation_events -> {
                    content = CurriculumVitaeDetailsFragment()
                    show(content as Fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_schedule -> {
                    content = CurriculumVitaeDetailsFragment()
                    show(content as Fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
        }
        false
    }*/
    /**
    * Private methods
    */
    private fun makeStateRestoration(savedInstanceState: Bundle){
        content = supportFragmentManager.getFragment(savedInstanceState, FRAGMENT_BUNDLE_KEY)
        currentItemID = savedInstanceState.getInt(CURRENTLY_SELECTED_OPTION_BUNDLE_KEY)
    }

    private fun makeScreenInitialization(){
        content = CurriculumVitaeDetailsFragment() // default page
        show(content as Fragment)
    }

    private fun show(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
