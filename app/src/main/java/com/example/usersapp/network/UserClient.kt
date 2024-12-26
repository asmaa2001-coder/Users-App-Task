package com.example.users.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserClient {
    private const val URL = "https://jsonplaceholder.typicode.com/"
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(URL).
                addConverterFactory(GsonConverterFactory.create())
                .build()

    }
    val service: UserService by lazy {
        retrofit.create(UserService::class.java)

    }
}