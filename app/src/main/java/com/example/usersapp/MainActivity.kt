package com.example.usersapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.users.ui.theme.pages.itemslist.ItemListScreen
import com.example.usersapp.ui.theme.UsersAppTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UsersAppTheme {
                ItemListScreen()
            }
        }
    }
}
