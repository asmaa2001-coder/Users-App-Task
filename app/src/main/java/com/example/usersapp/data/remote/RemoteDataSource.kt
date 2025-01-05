package com.example.usersapp.data.remote

import com.example.usersapp.domain.model.Users
import com.example.usersapp.data.remote.Route.END_POINT
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class RemoteDataSource(
    private val client: HttpClient
) : UserService {
    override suspend fun fetchUsers(): List<Users> {
        return client.get(END_POINT).body()
    }
}