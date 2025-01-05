package com.example.usersapp.di

import com.example.users.ui.theme.pages.itemslist.UsersItemsViewModel
import com.example.usersapp.UserApp
import com.example.usersapp.data.offline.LocalDataSource
import com.example.usersapp.data.offline.UserDateBase
import com.example.usersapp.data.remote.clientProvider
import com.example.usersapp.data.remote.RemoteDataSource
import com.example.usersapp.data.remote.UserService
import com.example.usersapp.domain.repository.DataRepository
import com.example.usersapp.domain.repository.DataRepositoryImpl
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { clientProvider() }
    single <UserService>{ RemoteDataSource(get()) }

    single { UserDateBase.getInstance(UserApp.getContext()) }
    single { get<UserDateBase>().dao }

    single { LocalDataSource(get()) }
    single<DataRepository> { DataRepositoryImpl(get(),get()) }
    viewModel { UsersItemsViewModel(get()) }
}