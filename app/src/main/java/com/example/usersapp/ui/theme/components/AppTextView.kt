package com.example.users.ui.theme.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppTextView(value: String , modifier: Modifier , textStyle: TextStyle) {
    Text(
        text = value ,
        modifier = modifier ,
        style = textStyle
    )

}

@Composable
@Preview(showBackground = true)
fun AppTextViewPreview() {
    AppTextView(
        value = "Hello Compose" ,
        modifier = Modifier.padding(16.dp) ,
        textStyle = MaterialTheme.typography.bodyLarge
    )
}