package com.example.movieTicket.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
@Composable
fun TextMovieTime(
    modifier: Modifier = Modifier,
    stringId :Int
){
    Text(
        text = stringResource(stringId),
        modifier = modifier,
        color = White, fontSize = 10.sp,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal
    )
}