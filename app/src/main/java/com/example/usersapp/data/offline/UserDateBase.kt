package com.example.usersapp.data.offline

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.usersapp.domain.model.Users

@Database(entities = [Users::class] , version = 1 , exportSchema = false)
@TypeConverters(Converter::class)
abstract class UserDateBase : RoomDatabase() {
    abstract val dao: UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDateBase? = null

        fun getInstance(context: Context): UserDateBase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext ,
                    UserDateBase::class.java ,
                    "User_Database"
                ).addTypeConverter(Converter())
                        .fallbackToDestructiveMigration()
                        .build()
                        .also { INSTANCE = it }
            }
        }
    }
}
