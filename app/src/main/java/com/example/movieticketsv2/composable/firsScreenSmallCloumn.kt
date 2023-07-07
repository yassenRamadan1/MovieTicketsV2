package com.example.movieTicket.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieticketsv2.ui.theme.Black60
import com.example.movieticketsv2.ui.theme.White60

@Composable
fun LittleColumn(firsString: String, secondString: String) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = firsString, color = Color.Black)
//        Spacer(modifier = Modifier)
        Text(text = secondString, color = Black60 )
    }

}

@Preview
@Composable
fun preview() {
    LittleColumn(firsString = "6.8/10", secondString = "IMDb")

}