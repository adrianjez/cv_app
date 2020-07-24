package com.hqapps.cvapp

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.hqapps.cvapp.ui.main.MainActivity
import com.hqapps.cvapp.ui.main.curriculumvitaedetails.CurriculumVitaeDetailsFragment
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest : ActivityTestRule<MainActivity>(MainActivity::class.java) {


    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp(){
        activityRule.launchActivity(Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER))
    }

    @Test
    fun isInitiallyProperlyDisplayed(){
        val currentFragment = activityRule.activity.supportFragmentManager.findFragmentById(R.id.fragment_container)
        MatcherAssert.assertThat<Fragment>(currentFragment, CoreMatchers.`is`(CoreMatchers.notNullValue()))
        MatcherAssert.assertThat<Fragment>(currentFragment, CoreMatchers.instanceOf(CurriculumVitaeDetailsFragment::class.java))
    }
}