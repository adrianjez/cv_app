package com.hqapps.dazntestapp

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.hqapps.dazntestapp.ui.main.MainActivity
import com.hqapps.dazntestapp.ui.main.events.EventsFragment
import com.hqapps.dazntestapp.ui.main.schedule.ScheduleFragment
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
        Espresso.onView(ViewMatchers.withId(R.id.navigationView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.navigation_events))
            .check(ViewAssertions.matches(ViewMatchers.isSelected()))
        val currentFragment = activityRule.activity.supportFragmentManager.findFragmentById(R.id.fragment_container)
        MatcherAssert.assertThat<Fragment>(currentFragment, CoreMatchers.`is`(CoreMatchers.notNullValue()))
        MatcherAssert.assertThat<Fragment>(currentFragment, CoreMatchers.instanceOf(EventsFragment::class.java))
    }

    @Test
    fun isProperlyScheduleDisplayedWhenSelected(){
        Espresso.onView(ViewMatchers.withId(R.id.navigation_schedule))
            .perform(ViewActions.click())
        val currentFragment = activityRule.activity.supportFragmentManager.findFragmentById(R.id.fragment_container)
        MatcherAssert.assertThat<Fragment>(currentFragment, CoreMatchers.`is`(CoreMatchers.notNullValue()))
        MatcherAssert.assertThat<Fragment>(currentFragment, CoreMatchers.instanceOf(ScheduleFragment::class.java))
    }


}