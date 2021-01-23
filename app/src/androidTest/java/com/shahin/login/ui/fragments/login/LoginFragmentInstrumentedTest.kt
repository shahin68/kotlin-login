package com.shahin.login.ui.fragments.login

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shahin.login.R
import com.shahin.login.ui.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginFragmentInstrumentedTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun initValidString() {

    }

    @Test
    fun validInputs_isTrue() {

        onView(withId(R.id.tiet_username)).perform(typeText("shahin"))
        onView(withId(R.id.tiet_pass)).perform(typeText("123"))
        onView(withId(R.id.tiet_pass_confirm)).perform(typeText("123"))

        onView(withId(R.id.btn)).perform(click(), closeSoftKeyboard())

    }

    @Test
    fun invalidInputs_passwordNotMatching_isFalse() {

        onView(withId(R.id.tiet_username)).perform(typeText("shahin"))
        onView(withId(R.id.tiet_pass)).perform(typeText("12"))
        onView(withId(R.id.tiet_pass_confirm)).perform(typeText("123"))

        onView(withId(R.id.btn)).perform(click(), closeSoftKeyboard())

    }

    @Test
    fun invalidInputs_emptyPassword_isFalse() {

        onView(withId(R.id.tiet_username)).perform(typeText("shahin"))
        onView(withId(R.id.tiet_pass)).perform(typeText("123"))
        onView(withId(R.id.tiet_pass_confirm)).perform(typeText(""))

        onView(withId(R.id.btn)).perform(click(), closeSoftKeyboard())

    }

}