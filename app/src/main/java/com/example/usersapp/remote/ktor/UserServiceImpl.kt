package com.example.usersapp.remote.ktor

import com.example.usersapp.domain.model.Users
import com.example.usersapp.remote.ktor.Route.END_POINT
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class UserServiceImpl(
    private val client: HttpClient
) : UserService {
    override suspend fun getUsers(): List<Users> {
        return client.get(END_POINT).body()
    }
}