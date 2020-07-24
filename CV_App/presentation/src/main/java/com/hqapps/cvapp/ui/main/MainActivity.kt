package com.hqapps.cvapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hqapps.cvapp.R
import com.hqapps.cvapp.ui.base.BaseActivity
import com.hqapps.cvapp.ui.main.curriculumvitaedetails.CurriculumVitaeDetailsFragment


class MainActivity : BaseActivity() {

    companion object {
        private const val FRAGMENT_BUNDLE_KEY = "FRAGMENT_BUNDLE_KEY"
    }

    private var content: Fragment? = null

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
    }

    /**
    * Private methods
    */
    private fun makeStateRestoration(savedInstanceState: Bundle){
        content = supportFragmentManager.getFragment(savedInstanceState, FRAGMENT_BUNDLE_KEY)
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
