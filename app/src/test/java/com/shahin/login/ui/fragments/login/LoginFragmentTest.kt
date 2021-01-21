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
    fun `validate all clear`() {
        val result = loginFragment.validateInputs("john", "1234", "1234")
        assertThat(result).isTrue()
    }

    @Test
    fun `validate empty username`() {
        val result = loginFragment.validateInputs("", "1234", "1234")
        assertThat(result).isFalse()
    }

    @Test
    fun `validate password matching`() {
        val pass = "1234"
        val passConfirmation = "123"
        val result = loginFragment.validateInputs("john", pass, passConfirmation)
        Truth.assertThat(result || pass.equals(passConfirmation, false)).isFalse()
    }

    @Test
    fun `validate empty password field`() {
        val result1 = loginFragment.validateInputs("john", "123", "")
        val result2 = loginFragment.validateInputs("john", "", "123")
        Truth.assertThat(result1 || result2).isFalse()
    }

}