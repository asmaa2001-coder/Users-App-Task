package com.example.usersapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

object Shape {
    val extraSmall = RoundedCornerShape(4.dp)
    val small = RoundedCornerShape(8.dp)
    val medium = RoundedCornerShape(16.dp)
    val large = RoundedCornerShape(20.dp)
    val extraLarge = RoundedCornerShape(32.dp)
    val circle = RoundedCornerShape(50)
    val shapes : Shapes = Shapes(
        extraSmall = extraSmall ,
        small = small ,
        medium = medium ,
        large = large ,
        extraLarge = extraLarge
    )

}