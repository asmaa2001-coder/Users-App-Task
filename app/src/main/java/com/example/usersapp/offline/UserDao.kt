package com.example.usersapp.offline

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.usersapp.domain.model.Users
import kotlinx.coroutines.flow.Flow
@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getLikedUsers(): List<Users>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: Users)

    @Query("DELETE FROM users WHERE id = :id")
    suspend fun deleteUser(id: Int)
}