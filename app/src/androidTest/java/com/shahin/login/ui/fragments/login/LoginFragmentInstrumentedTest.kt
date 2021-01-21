package com.shahin.login.ui.fragments.login

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Before
import org.junit.Test

class LoginFragmentInstrumentedTest {

    private lateinit var loginFragment: LoginFragment

    @Before
    fun start() {
        loginFragment = LoginFragment()
    }

    @After
    fun finish() {

    }

    @Test
    fun `test`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
    }

}