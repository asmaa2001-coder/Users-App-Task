package com.example.usersapp.data.offline

import com.example.usersapp.domain.model.Users

class LocalDataSource(private val userDao: UserDao) {
    suspend fun getLikedUsers(): List<Users> {
        return userDao.getLikedUsers()
    }

    suspend fun saveUser(user: Users) {
        userDao.saveUser(user)
    }

    suspend fun deleteUser(userId: Int) {
        userDao.deleteUser(userId)
    }

}