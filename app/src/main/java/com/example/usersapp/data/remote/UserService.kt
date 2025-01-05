package com.example.usersapp.data.remote

import com.example.usersapp.domain.model.Users


interface UserService {
    suspend fun fetchUsers(): List<Users>
}