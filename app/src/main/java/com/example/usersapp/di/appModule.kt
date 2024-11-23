package com.example.usersapp.di

import com.example.users.network.UserClient
import com.example.users.ui.theme.pages.itemslist.UsersItemsViewModel
import com.example.usersapp.UserApp
import com.example.usersapp.offline.UserDateBase

//val appModule = module {
//    single { UserClient.service }
//    single { UserDateBase.getInstance(UserApp.getContext()) }
//    single { get<UserDateBase>().dao }
//    single { UsersItemsViewModel(get(), get(),get()) }
//}