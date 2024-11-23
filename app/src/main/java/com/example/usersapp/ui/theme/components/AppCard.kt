package com.example.users.ui.theme.components

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppCard(
    modifier: Modifier = Modifier ,
    shape: Shape = MaterialTheme.shapes.medium ,
    elevation: Dp = 1.dp , content: @Composable () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = elevation) ,
        modifier = modifier ,
        shape = shape
    ) {
        content()
    }

}

@Composable
@Preview(showBackground = true)
fun AppCardPreview() {
    AppCard(content = {})

}