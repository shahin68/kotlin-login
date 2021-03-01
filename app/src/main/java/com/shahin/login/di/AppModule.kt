package com.shahin.login.di

import com.shahin.login.data.sources.Repository
import com.shahin.login.data.sources.RepositoryImpl
import com.shahin.login.ui.fragments.login.LoginViewModel
import com.shahin.login.ui.fragments.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { MainViewModel() }

    factory<Repository> { RepositoryImpl() }
}