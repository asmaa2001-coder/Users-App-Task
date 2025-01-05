package com.example.usersapp.di

import com.example.users.ui.theme.pages.itemslist.UsersItemsViewModel
import com.example.usersapp.UserApp
import com.example.usersapp.data.offline.LocalDataSource
import com.example.usersapp.data.offline.UserDateBase
import com.example.usersapp.data.remote.RemoteDataSource
import com.example.usersapp.data.remote.UserService.Companion.serviceCreate
import com.example.usersapp.domain.repository.DataRepository
import com.example.usersapp.domain.repository.DataRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { serviceCreate() }
    single { RemoteDataSource(get()) }

    single { UserDateBase.getInstance(UserApp.getContext()) }
    single { get<UserDateBase>().dao }

    single { LocalDataSource(get()) }
    single<DataRepository> { DataRepositoryImpl(get(),get()) }
    viewModel { UsersItemsViewModel(get()) }
}