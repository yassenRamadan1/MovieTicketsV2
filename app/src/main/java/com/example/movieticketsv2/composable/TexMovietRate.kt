package com.example.movieTicket.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextMovieRate(stringId: Int, color: Color = Color.Black, fontSize: Int) {
    Text(
        text = stringResource(stringId), fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        color = color, fontSize = fontSize.sp,
    )
}