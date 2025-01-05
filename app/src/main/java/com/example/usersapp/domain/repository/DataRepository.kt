package com.example.usersapp.domain.repository

import com.example.usersapp.domain.model.Users

interface DataRepository {
    suspend fun getData():List<Users>
    suspend fun saveFavourites(users: Users)
    suspend fun getFavourites():List<Users>
    suspend fun deleteFavouriteUser(users: Users)
}