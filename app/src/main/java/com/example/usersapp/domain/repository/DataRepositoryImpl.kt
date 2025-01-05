package com.example.usersapp.domain.repository

import com.example.usersapp.data.offline.LocalDataSource
import com.example.usersapp.data.remote.RemoteDataSource
import com.example.usersapp.data.remote.UserService
import com.example.usersapp.domain.model.Users

class DataRepositoryImpl(
    private val remoteDataSource: UserService ,
    private val localDataSource: LocalDataSource
) : DataRepository {
    override suspend fun getData(): List<Users> {
        return try {
            remoteDataSource.fetchUsers()
        } catch (e: Exception) {
            localDataSource.getLikedUsers()
        }
    }

    override suspend fun saveFavourites(users: Users) {
        return localDataSource.saveUser(user = users)
    }

    override suspend fun getFavourites(): List<Users> {
        return localDataSource.getLikedUsers()
    }

    override suspend fun deleteFavouriteUser(users: Users) {
        return localDataSource.deleteUser(users.id)
    }
}