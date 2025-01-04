package com.example.usersapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.users.ui.theme.pages.itemslist.ItemListScreen
import com.example.usersapp.remote.ktor.UserService
import com.example.usersapp.ui.theme.UsersAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UsersAppTheme {
                ItemListScreen()
                //ScreenFilter()
//                lifecycleScope.launch {
//                    val users = service.getUsers()
//                    if (users.isEmpty()) {
//                        Log.e("Asmaa" , "No data")
//                    } else {
//                        Log.i("Asmaa" , "${users[0]}")
//                    }
//                }
            }
        }
    }
}
