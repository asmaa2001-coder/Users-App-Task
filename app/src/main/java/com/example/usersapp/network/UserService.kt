package com.example.users.network

import com.example.usersapp.domain.model.Users
import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getUsers():List<Users>
}