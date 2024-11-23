package com.example.usersapp

import android.app.Application
import android.content.Context



class UserApp : Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
//        startKoin {
//            androidContext(this@UserApp)
//            modules(appModule)
//        }

    }

    companion object {
        private lateinit var application: UserApp

        fun getContext(): Context {
            if (!::application.isInitialized) {
                throw IllegalStateException("Application not initialized")
            }
            return application.applicationContext
        }
    }
}