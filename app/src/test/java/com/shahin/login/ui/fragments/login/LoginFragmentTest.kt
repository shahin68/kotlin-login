package com.shahin.login.ui.fragments.login

import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class LoginFragmentTest {
    private lateinit var loginFragment: LoginFragment

    @Before
    fun start() {
        loginFragment = LoginFragment()
    }

    @After
    fun finish() {

    }


    @Test
    fun validInputs_isTrue() {
        val result = loginFragment.checkInputs("john", "1234", "1234")
        Truth.assertThat(result).isTrue()
    }

    @Test
    fun invalidInputs_emptyUsername_isFalse() {
        val result = loginFragment.checkInputs("", "1234", "1234")
        Truth.assertThat(result).isFalse()
    }

    @Test
    fun invalidInputs_passwordNotMatching_isFalse() {
        val pass = "1234"
        val passConfirmation = "123"
        val result = loginFragment.checkInputs("john", pass, passConfirmation)
        Truth.assertThat(result || pass.equals(passConfirmation, false)).isFalse()
    }

    @Test
    fun invalidInputs_emptyPasswordField_isFalse() {
        val result1 = loginFragment.checkInputs("john", "123", "")
        val result2 = loginFragment.checkInputs("john", "", "123")
        Truth.assertThat(result1 || result2).isFalse()
    }
}