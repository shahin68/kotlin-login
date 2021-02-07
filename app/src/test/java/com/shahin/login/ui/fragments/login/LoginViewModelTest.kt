package com.shahin.login.ui.fragments.login

import com.google.common.truth.Truth
import com.shahin.login.data.sources.RepositoryImplTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class LoginViewModelTest {

    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun start() {
        loginViewModel = LoginViewModel(RepositoryImplTest())
    }

    @Test
    fun validInputs_isTrue() {
        val result = loginViewModel.verifyInputs("john", "1234", "1234")
        Truth.assertThat(result).isTrue()
    }

    @Test
    fun invalidInputs_emptyUsername_isFalse() {
        val result = loginViewModel.verifyInputs("", "1234", "1234")
        Truth.assertThat(result).isFalse()
    }

    @Test
    fun invalidInputs_passwordNotMatching_isFalse() {
        val pass = "1234"
        val passConfirmation = "123"
        val result = loginViewModel.verifyInputs("john", pass, passConfirmation)
        Truth.assertThat(result || pass.equals(passConfirmation, false)).isFalse()
    }

    @Test
    fun invalidInputs_emptyPasswordField_isFalse() {
        val result1 = loginViewModel.verifyInputs("john", "123", "")
        val result2 = loginViewModel.verifyInputs("john", "", "123")
        Truth.assertThat(result1 || result2).isFalse()
    }
}