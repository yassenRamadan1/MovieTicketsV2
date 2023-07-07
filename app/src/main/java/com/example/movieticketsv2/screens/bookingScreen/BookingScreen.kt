package com.example.movieTicket.screens.bookingScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.movieTicket.AppDestination
import com.example.movieTicket.composable.ButtonBooking
import com.example.movieTicket.composable.CustomChip
import com.example.movieTicket.composable.ImageFromUrl
import com.example.movieTicket.composable.LittleColumn
import com.example.movieTicket.composable.SetTopImage
import com.example.movieTicket.composable.SpacerHorizontal8
import com.example.movieticketsv2.R

@Composable
fun BookingScreen(
    navController: NavController,
    viewModel: BookingViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    BookingScreenContent(state){
        navController.navigate(AppDestination.BuyTicketsScreen.route)
    }
}

@Composable
fun BookingScreenContent(state: List<String>, onClickBooking: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        SetTopImage()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.54f)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(topEnd = 25.dp, topStart = 25.dp),
            colors = CardDefaults.cardColors(contentColor = Color.White),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween,

                ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    LittleColumn(firsString = "6.8/10", secondString = "IMDb")
                    LittleColumn(firsString = "63%", secondString = "Rotten Tomatoes")
                    LittleColumn(firsString = "4/10", secondString = "IGN")

                }

                Text(
                    text = stringResource(R.string.fantastic_beasts_name),
                    modifier = Modifier.padding(horizontal = 30.dp),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black,
                    fontSize = 24.sp,
                    maxLines = 2,
                    softWrap = true,
                    fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                    textAlign = TextAlign.Center,
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CustomChip(text = stringResource(R.string.fantasy)){}
                    SpacerHorizontal8()
                    CustomChip(text = stringResource(R.string.adventure)){}
                }
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(state.size) {
                        ImageFromUrl(
                            url = state[it],
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape),
                            description = stringResource(R.string.actor_image)
                        )
                    }
                }
                Text(
                    text = names.content,
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Black, fontSize = 14.sp),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    textAlign = TextAlign.Center

                )
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp), contentAlignment = Alignment.Center) {
                    ButtonBooking(stringId = R.string.booking,140,onClickBooking)

                }




            }
        }


    }


}


@Preview
@Composable
fun PreviewScreen(){

}

object names {
    const val content =
        "professor Albus  Dumbledore knows the powerful, dark wizard Gellert Grindelwald is moving to seize control of the Wizarding world. Unable to stop him\u00AD mm"
}