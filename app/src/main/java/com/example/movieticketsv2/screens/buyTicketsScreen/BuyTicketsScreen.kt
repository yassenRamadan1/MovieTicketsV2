package com.example.movieTicket.screens.buyTicketsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.movieTicket.composable.ButtonBooking
import com.example.movieTicket.composable.ChairStateTextWithColor
import com.example.movieTicket.composable.CinemaChairsGrid
import com.example.movieTicket.composable.IconClose
import com.example.movieTicket.composable.ImageFromUrl
import com.example.movieTicket.composable.ReservationDateItem
import com.example.movieTicket.composable.ReservationTimeItem
import com.example.movieTicket.composable.TextMovieRate
import com.example.movieticketsv2.R
import com.example.movieticketsv2.ui.theme.Black
import com.example.movieticketsv2.ui.theme.LightGray
import com.example.movieticketsv2.ui.theme.Orange
import com.example.movieticketsv2.ui.theme.White
import com.example.movieticketsv2.ui.theme.navy

@Composable
fun BuyTicketsScreen(
    navController: NavController,
    viewModel: BuyTicketsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    BuyTicketsContent(
        buyTicketsUiState = state,
        onClickDay = viewModel::onClickDay,
        onClickTime = viewModel::onClickTime,
        onClickChair = viewModel::onClickChair,
        onClickBuyTickets = {}
    )
}

@Composable
private fun BuyTicketsContent(
    buyTicketsUiState: BuyTicketsUiState,
    modifier: Modifier = Modifier,
    onClickChair: () -> Unit,
    onClickDay: (Int) -> Unit,
    onClickTime: (Int) -> Unit,
    onClickBuyTickets: () -> Unit
) {
    val curveShape = CustomShape()
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Column(
            Modifier
                .fillMaxSize()
                .background(Black)
                .padding(16.dp),
        ) {
            IconClose()
            ImageFromUrl(
                url = "https://theknackinitiative.files.wordpress.com/2014/03/bane-batman-standoff-the-dark-knight-rises-wall-poster1.jpg",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .clip(shape = curveShape)
                    .alpha(0.7f)
                    .padding(bottom = 8.dp),
                scale = ContentScale.FillWidth,
            )
            CinemaChairsGrid(buyTicketsUiState =buyTicketsUiState
                ,modifier= Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
                , onClickChair)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                ChairStateTextWithColor(text = stringResource(R.string.available),
                    color = White ,
                    textColor = LightGray.copy(alpha = 0.38f ))
                ChairStateTextWithColor(text = stringResource(R.string.Taken),
                    color = LightGray.copy(alpha = 0.38f ) ,
                    textColor = LightGray.copy(alpha = 0.38f ))
                ChairStateTextWithColor(text = stringResource(R.string.Selected),
                    color = Orange ,
                    textColor = LightGray.copy(alpha = 0.38f ))
            }
        }
        Card(
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(White),
            modifier = Modifier
                .heightIn(250.dp, 500.dp)
                .background(Color.Transparent)
        ) {
            Column {
                LazyRow(
                    contentPadding = PaddingValues(16.dp)
                ) {
                    val weekDays: List<String> =
                        listOf("Thu", "Fri", "Sat", "Sun", "Mon", "Thr", "Wed")
                    items(buyTicketsUiState.reservationDays.size) {
                        val background = if (buyTicketsUiState.selectedDay == it) LightGray else White
                        val textColor = if (buyTicketsUiState.selectedDay == it) White else navy
                        ReservationDateItem(
                            boxColor = background,
                            dayOFMonth = buyTicketsUiState.reservationDays[it].toString(),
                            dayOfWeek = weekDays[it],
                            textColor = textColor,
                            onClickItem = { onClickDay(it) }
                        )
                    }
                }
                LazyRow(contentPadding = PaddingValues(16.dp)) {
                    items(buyTicketsUiState.reservationTime.size) {
                        val background = if (buyTicketsUiState.selectedTime == it) LightGray else White
                        val textColor = if (buyTicketsUiState.selectedTime == it) White else navy
                        ReservationTimeItem(
                            boxColor = background,
                            reservationTime = buyTicketsUiState.reservationTime[it],
                            textColor = textColor,
                            onClickItem = { onClickTime(it) }
                        )
                    }
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        TextMovieRate(stringId = R.string.one_hundred, fontSize = 18, color = Black)
                        TextMovieRate(
                            stringId = R.string.one_hundred,
                            fontSize = 12,
                            color = Color.LightGray
                        )
                    }
                    ButtonBooking(
                        stringId = R.string.buy_tickets,
                        width = 160,
                        onClickEvent = onClickBuyTickets
                    )
                }
            }
        }
    }
}
@Preview
@Composable
fun PreviewTheScreen(){
}