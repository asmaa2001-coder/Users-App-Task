package com.example.users.ui.theme.pages.itemslist

sealed class UsersItemsIntent {
    object FetchUsers : UsersItemsIntent()
    data class ToggleLikeUser(val userId: Int) : UsersItemsIntent()

}