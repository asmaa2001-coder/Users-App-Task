package com.example.usersapp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object Route {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    const val END_POINT = "$BASE_URL/users"
}

private const val TIME_OUT = 5000L

fun clientProvider(): HttpClient {
    return HttpClient(Android) {
        install(
            ContentNegotiation
        ) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    encodeDefaults = false
                    coerceInputValues = true
                }
            )
        }
        install(HttpTimeout) {
            requestTimeoutMillis = TIME_OUT
            connectTimeoutMillis = TIME_OUT
            socketTimeoutMillis = TIME_OUT

        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL

        }
        defaultRequest {
            headers.append("Content-Type" , "application/json")
        }

    }


}

