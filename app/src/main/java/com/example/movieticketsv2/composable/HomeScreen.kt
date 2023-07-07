package com.example.movieTicket.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieticketsv2.ui.theme.primaryTextColor

@Composable
fun profileScreen(){
Column(modifier = Modifier
    .fillMaxSize()
    .padding(horizontal = 16.dp, vertical = 32.dp)
) {
Text(text = "Kareem", color = primaryTextColor,
)
}

}


@Preview(showSystemUi = true)
@Composable
fun previewProfileScreen(){
profileScreen()

}