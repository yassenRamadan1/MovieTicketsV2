package com.example.movieTicket.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.movieticketsv2.R

@Composable
fun ListTry() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .clickable() {},
        elevation = CardDefaults.cardElevation(10.dp)
    ) {

        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = "https://w0.peakpx.com/wallpaper/600/322/HD-wallpaper-anime-boy-anime-boy-anime-boys-cute-cute-anime-boy-cute-anime-boys-lonely-sad-anime-boy-sad-anime-boys.jpg"),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(stringResource(R.string.this_is_the_card))
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun TryListTry() {
    ListTry()
}