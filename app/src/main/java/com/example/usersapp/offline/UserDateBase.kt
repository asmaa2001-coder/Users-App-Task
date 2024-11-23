package com.example.usersapp.offline

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.usersapp.domain.model.Users
import com.example.usersapp.network.Converter

@Database(
    entities = [Users::class] ,
    version = 1 ,
    exportSchema = false
)

@TypeConverters(Converter::class)
abstract class UserDateBase() : RoomDatabase() {
    abstract val dao: UserDao

    companion object {
        @Volatile
        private var dataBaseInstance: UserDao? = null
        private fun createInstance(context: Context): UserDateBase {
            return Room.databaseBuilder(
                context.applicationContext ,
                UserDateBase::class.java ,
                "User_Database"
            ).addTypeConverter(Converter())
                    .fallbackToDestructiveMigration().build()
        }

        fun getInstance(context: Context): UserDao {
            synchronized(this) {
                if (dataBaseInstance == null) {
                    dataBaseInstance = createInstance(context).dao
                }
                return dataBaseInstance as UserDao
            }
        }

    }

}