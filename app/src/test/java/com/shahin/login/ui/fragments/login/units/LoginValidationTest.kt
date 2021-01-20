package com.shahin.login.ui.fragments.login.units

import com.google.common.truth.Truth.*
import org.junit.Test

class LoginValidationTest{

    @Test
    fun `validate all clear`() {
        val result = LoginValidation.validateInputs("john", "1234", "1234")
        assertThat(result).isTrue()
    }

    @Test
    fun `validate empty username`() {
        val result = LoginValidation.validateInputs("", "1234", "1234")
        assertThat(result).isFalse()
    }

    @Test
    fun `validate password matching`() {
        val pass = "1234"
        val passConfirmation = "123"
        val result = LoginValidation.validateInputs("john", pass, passConfirmation)
        assertThat(result || pass.equals(passConfirmation, false)).isFalse()
    }

    @Test
    fun `validate empty password field`() {
        val result1 = LoginValidation.validateInputs("john", "123", "")
        val result2 = LoginValidation.validateInputs("john", "", "123")
        assertThat(result1 || result2).isFalse()
    }
}