package com.example.usersapp.di

import com.example.users.network.UserClient
import com.example.users.ui.theme.pages.itemslist.UsersItemsViewModel
import com.example.usersapp.UserApp
import com.example.usersapp.offline.UserDateBase
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { UserClient.service }
    single { UserDateBase.getInstance(UserApp.getContext()) }
    single { get<UserDateBase>().dao }
    viewModel { UsersItemsViewModel(get() , get()) }
}