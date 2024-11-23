package com.example.users.ui.theme.pages.itemslist

import com.example.usersapp.domain.model.Users

data class UsersItemsViewState (
    val isLoading: Boolean = false ,
    val users: List<Users> = emptyList() ,
    val error: String? = null ,
    val likedUsers: List<Users> = emptyList()
)