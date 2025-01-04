package com.example.usersapp.di

import com.example.users.ui.theme.pages.itemslist.UsersItemsViewModel
import com.example.usersapp.UserApp
import com.example.usersapp.offline.UserDateBase
import com.example.usersapp.remote.ktor.UserService.Companion.serviceCreate
import com.example.usersapp.remote.ktor.UserServiceImpl
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private const val TIME_OUT = 1500L
val appModule = module {
    single { serviceCreate() }
    single { UserServiceImpl(get()) }
    single { UserDateBase.getInstance(UserApp.getContext()) }
    single { get<UserDateBase>().dao }
    viewModel { UsersItemsViewModel(get() , get()) }
}