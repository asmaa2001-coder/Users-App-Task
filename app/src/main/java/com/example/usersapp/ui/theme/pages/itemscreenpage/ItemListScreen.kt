package com.example.users.ui.theme.pages.itemslist

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.users.ui.theme.components.AppLoadingBar
import com.example.users.ui.theme.components.AppTextView
import com.example.users.ui.theme.components.ItemContent
import com.example.usersapp.domain.model.Users
import org.koin.androidx.compose.koinViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
@Preview(showSystemUi = true)
fun ItemListScreen(viewModel: UsersItemsViewModel = koinViewModel()) {
    val state = viewModel.state.collectAsState().value

    if (state.isLoading) {
        AppLoadingBar()
    } else if (state.error != null || state.users.isEmpty()) {
        Box(
            contentAlignment = androidx.compose.ui.Alignment.Center ,
            modifier = Modifier.fillMaxSize()
        ) {
            AppTextView(
                value = "No Restoring Data" ,
                modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .align(androidx.compose.ui.Alignment.Center) ,
                textStyle = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.error)
            )
        }
    } else {
        UsersItemsContent(state = state , onIntent = viewModel::handleIntent)
    }

}

@Composable
fun UsersItemsContent(
    state: UsersItemsViewState ,
    onIntent: (UsersItemsIntent) -> Unit
) {
    LazyColumn(
        modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
    ) {
        items(state.users.size) { item ->
            Log.i("data user" , "${state.users[item]}")
            ItemContent(
                name = state.users[item].name ,
                email = state.users[item].email ,
                phone = state.users[item].phone ,
                image = if (state.users[item].liked) Icons.Default.Favorite else Icons.Default.FavoriteBorder ,
                onClick = {
                    onIntent(UsersItemsIntent.ToggleLikeUser(state.users[item].id))
                } ,
                companyName = state.users[item].company.name
            )
        }
    }
}

@Composable
fun KtorList(list: List<Users>){
    LazyColumn(
        modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
    ) {
        items(list.size) { item ->
            ItemContent(
                name = list[item].name,
                email = list[item].email ,
                phone = list[item].phone ,
                image = if (list[item].liked) Icons.Default.Favorite else Icons.Default.FavoriteBorder ,
                onClick = {

                } ,
                companyName = list[item].company.name
            )
        }
    }
}
