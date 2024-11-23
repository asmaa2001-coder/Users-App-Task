package com.example.users.ui.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ImageIcon(
    icon: ImageVector ,
    description: String ,
    modifier: Modifier ,
    clickable: () -> Unit,
    tint: Color = Color.Red
) {
    Image(imageVector = icon ,
        contentDescription = description , modifier = modifier
                .clickable {
                    clickable()
                },
        colorFilter = ColorFilter.tint(color = tint)
    )
}

@Composable
@Preview(showBackground = true)
fun ImageIconPreview() {
    ImageIcon(
        icon = Icons.Default.Favorite ,
        description = "Favorite" ,
        modifier = Modifier.padding(4.dp) ,
        clickable = {})
}