package com.mobile.android.chameapps.towatchlist

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.mobile.android.chameapps.towatchlist.ui.mainactivity.MainActivity
import org.junit.Rule
import org.junit.Test

/**
 * Created by Natallia Zhabitskaya on 04/13/2020.
 */

class MainActivityTest {
    @get:Rule
    var mainActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun viewModelInjected() {
        onView(withId(R.id.fab)).perform(click())
        onView(withText("Create a movie")).check(matches(isDisplayed()))
    }
}