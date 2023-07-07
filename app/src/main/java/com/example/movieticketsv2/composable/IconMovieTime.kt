package com.example.movieTicket.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieticketsv2.R


@Composable
fun IconMovieTime(backgroundColor: Color = Color.Transparent) {
    Box(
        Modifier
            .size(76.dp, 28.dp)
            .background(backgroundColor, RoundedCornerShape(12.dp)), Alignment.Center
    )
    {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Rounded.AccessTime,
                contentDescription = "Movie Time",
                modifier = Modifier.padding(horizontal = 2.dp),
                tint = Color.LightGray
            )
            TextMovieTime(stringId =  R.string.time_hour)
            TextMovieTime(stringId = R.string.time_in_min, modifier = Modifier.padding(horizontal = 2.dp))
        }
    }
}
@Preview
@Composable
fun IconMovieTimePreview(){
    IconMovieTime()
}