package com.example.usersapp

import android.app.Application
import android.content.Context
import com.example.usersapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level


class UserApp : Application() {
    override fun onCreate() {
        super.onCreate()
        application = this
        startKoin {
            androidContext(this@UserApp)
            printLogger(Level.DEBUG)
            modules(appModule)
        }

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