package com.example.movieTicket.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieticketsv2.R
import com.example.movieticketsv2.ui.theme.Orange

@Composable
fun SetTopImage() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f),


        ) {

        Image(
            painter = painterResource(id = R.drawable.fantastic_beasts_cover),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            IconClose()
            IconMovieTime(backgroundColor = LightGray.copy(alpha =0.20f))
        }
        Button(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.Center)
                .size(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange
            ),
            elevation = ButtonDefaults.buttonElevation(0.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Icon(painterResource(id = R.drawable.play), contentDescription = null)

        }

    }


// {
//    val (image,button,text) = createRefs()
//        Image(
//            painter = painterResource(id = R.drawable.fantastic_beasts_cover),
//            contentDescription = null,
//            modifier = Modifier.fillMaxWidth().constrainAs(image){
//                height =
//            }
//        )
//
// }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewImage() {
    SetTopImage()
}