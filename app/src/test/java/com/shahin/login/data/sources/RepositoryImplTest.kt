package com.shahin.login.data.sources

import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class RepositoryImplTest {
    private lateinit var repositoryImpl: RepositoryImpl

    @Before
    fun start() {
        repositoryImpl = RepositoryImpl()
    }

    @After
    fun finish() {

    }


    @Test
    fun validInputs_isTrue() {
        val result = repositoryImpl.verify("john", "1234", "1234")
        assertThat(result).isTrue()
    }

    @Test
    fun invalidInputs_emptyUsername_isFalse() {
        val result = repositoryImpl.verify("", "1234", "1234")
        assertThat(result).isFalse()
    }

    @Test
    fun invalidInputs_passwordNotMatching_isFalse() {
        val pass = "1234"
        val passConfirmation = "123"
        val result = repositoryImpl.verify("john", pass, passConfirmation)
        Truth.assertThat(result || pass.equals(passConfirmation, false)).isFalse()
    }

    @Test
    fun invalidInputs_emptyPasswordField_isFalse() {
        val result1 = repositoryImpl.verify("john", "123", "")
        val result2 = repositoryImpl.verify("john", "", "123")
        Truth.assertThat(result1 || result2).isFalse()
    }
}