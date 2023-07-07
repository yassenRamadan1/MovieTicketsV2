package com.example.movieTicket.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieticketsv2.ui.theme.White

@Composable
fun ChairStateTextWithColor(text: String,color: Color,textColor:Color,modifier: Modifier = Modifier){
   Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
       Box(modifier = Modifier.size(8.dp).clip(CircleShape).background(color))
       Text(text = text,color =textColor )
   }
}
@Preview
@Composable
fun PreviewFunction(){
    ChairStateTextWithColor("123", White, White)
}