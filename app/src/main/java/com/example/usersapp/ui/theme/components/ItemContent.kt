package com.example.users.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.usersapp.ui.theme.Purple40
import com.example.usersapp.ui.theme.PurpleGrey40
import com.example.usersapp.ui.theme.Shape
import com.example.usersapp.ui.theme.Shape.medium

@Composable
fun ItemContent(
    name: String ,
    email: String ,
    phone: String ,
    companyName: String ,
    image: ImageVector ,
    onClick: () -> Unit = {}

) {
    AppCard(
        modifier = Modifier
                .wrapContentHeight()
                .background(Color.White)
                .padding(10.dp)
                .fillMaxWidth()
                .border(1.dp , PurpleGrey40.copy(alpha = .4f) , shape = medium)
                .shadow(2.dp , medium) ,
        shape = Shape.medium ,
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            AppTextView(
                value = name ,
                modifier = Modifier.padding(4.dp) ,
                textStyle = MaterialTheme.typography.titleLarge.copy(
                    color = Purple40 ,
                    fontWeight = FontWeight.Bold
                )
            )
            Row(horizontalArrangement = Arrangement.Center) {
                AppTextView(
                    value = companyName ,
                    modifier = Modifier
                            .padding(4.dp) ,
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        color = Purple40.copy(
                            alpha = 0.8f
                        ) , fontWeight = FontWeight.SemiBold
                    )
                )
                ImageIcon(
                    icon = image ,
                    description = "fav icon" ,
                    modifier = Modifier.padding(4.dp) ,
                    clickable = { onClick() },
                    tint = Purple40
                )
            }

            Column(verticalArrangement = Arrangement.Center) {
                AppTextView(
                    value = email ,
                    modifier = Modifier.padding(4.dp).align(Alignment.CenterHorizontally) ,
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black.copy(
                            alpha = 0.8f
                        )
                    )
                )
                AppTextView(
                    value = phone ,
                    modifier = Modifier.padding(4.dp).align(Alignment.CenterHorizontally) ,
                    textStyle = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black.copy(
                            alpha = 0.8f
                        )
                    )
                )
            }

        }

    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewItem() {
    ItemContent(
        name = "Asmaa" ,
        email = "asmaa.gmail.com" ,
        phone = "01023948586" ,
        companyName = "Cairo" ,
        image = Icons.Default.FavoriteBorder
    )
}

