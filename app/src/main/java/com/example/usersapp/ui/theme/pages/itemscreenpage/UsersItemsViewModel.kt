package com.example.users.ui.theme.pages.itemslist

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.users.network.UserClient
import com.example.usersapp.UserApp.Companion.getContext
import com.example.usersapp.domain.model.Users
import com.example.usersapp.offline.UserDateBase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsersItemsViewModel() : ViewModel() {
    private val _state = MutableStateFlow(UsersItemsViewState())
    val state: StateFlow<UsersItemsViewState> = _state.asStateFlow()

    private val userDao = UserDateBase.getInstance(getContext())
    private val apiService = UserClient.service

    private val handleError = CoroutineExceptionHandler { _, error ->
        error.printStackTrace()
        Log.e("Users", error.toString())
    }



    init {
        loadUsers()
    }

    /**
     * Handle user intents.
     */
    fun handleIntent(intent: UsersItemsIntent) {
        when (intent) {
            is UsersItemsIntent.FetchUsers -> loadUsers()
            is UsersItemsIntent.ToggleLikeUser -> toggleUserLike(intent.userId)
        }
    }

    /**
     * Fetch and update the user list from API or offline sources.
     */
    private fun loadUsers() {
        _state.value = _state.value.copy(isLoading = true)

        viewModelScope.launch(handleError) {
            getUsers()?.let { users ->
                _state.emit(_state.value.copy(users = users, isLoading = false))
            }
        }
    }

    private suspend fun getUsers(): List<Users> = withContext(Dispatchers.IO) {
        try {
            val apiUsers = apiService.getUsers()
            val cachedLikes = userDao.getLikedUsers()
            return@withContext apiUsers.mergeWithCachedLikes(cachedLikes)
        } catch (e: Exception) {
            return@withContext userDao.getLikedUsers()
        }
    }

    /**
     * Merge API users with cached liked states.
     */
    private fun List<Users>.mergeWithCachedLikes(cachedUsers: List<Users>): List<Users> {
        val cachedMap = cachedUsers.associateBy { it.id }
        return this.map { user ->
            user.copy(liked = cachedMap[user.id]?.liked ?: false)
        }
    }

    /**
     * Toggle the liked status of a user and update the cache.
     */
    private fun toggleUserLike(userId: Int) {
        viewModelScope.launch(handleError) {
            try {
                val currentUsers = _state.value.users
                val user = currentUsers.find { it.id == userId } ?: return@launch

                val updatedUser = user.copy(liked = !user.liked)
                val updatedUsers = currentUsers.map { if (it.id == userId) updatedUser else it }

                _state.emit(_state.value.copy(users = updatedUsers))

                if (updatedUser.liked) {
                    userDao.saveUser(updatedUser)
                } else {
                    userDao.deleteUser(userId)
                }
            } catch (e: Exception) {
                _state.emit(_state.value.copy(error = e.message))
            }
        }
    }
}
