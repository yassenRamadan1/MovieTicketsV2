package com.example.movieTicket.screens.filmsScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.movieTicket.AppDestination
import com.example.movieTicket.composable.CustomChip
import com.example.movieTicket.composable.FilmBackGround
import com.example.movieTicket.composable.HorizontalFilmsPager
import com.example.movieTicket.composable.SpacerHorizontal8
import com.example.movieticketsv2.R
import com.example.movieticketsv2.ui.theme.Orange

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FilmsScreen(
    navController: NavController,
    viewModel: FilmsScreenViewModel = hiltViewModel()
) {
    val state by viewModel.filmsState.collectAsState()
    val pagerState = rememberPagerState()
    FilmsScreenContent(state = state, pagerState = pagerState) {
        navController.navigate(AppDestination.BookingScreen.route)
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FilmsScreenContent(
    state: FilmsUiState,
    pagerState: PagerState,
    onClickPhoto:()->Unit
)   {
    Box(modifier = Modifier.fillMaxSize()){
        FilmBackGround(state = state, pagerState = pagerState)
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                CustomChip(
                    text = stringResource(R.string.now_showing),
                    textColor = Color.White,
                    buttonColor = Orange
                ) {}
                SpacerHorizontal8()
                CustomChip(text = stringResource(R.string.coming_soon),
                    textColor = Color.White) {}
            }
            HorizontalFilmsPager(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp),
                filmsUiState = state,
                pagerState = pagerState
            ) { onClickPhoto()}
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.AccessTime,
                    contentDescription = "clock",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(text = "2h 23m")
            }

            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                text = "Fantastic Beasts: The\nSecrets of Dumbledore",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CustomChip( text = stringResource(R.string.fantasy)) {}
                SpacerHorizontal8()
                CustomChip(text = stringResource(R.string.adventure)) {}
            }

        }

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun FilmsScreenPreview(){
}