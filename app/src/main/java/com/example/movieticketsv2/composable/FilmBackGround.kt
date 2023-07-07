package com.example.movieTicket.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.movieTicket.screens.filmsScreen.FilmsUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FilmBackGround(state: FilmsUiState, pagerState: PagerState){
    Image(
        modifier = Modifier
            .fillMaxSize()
            .blur(60.dp),
        contentScale = ContentScale.Crop,
        painter = rememberAsyncImagePainter(model = state.filmsPhotos[pagerState.currentPage]),
        contentDescription = ""
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Transparent,
                        Color.White,
                        Color.White
                    )
                )
            )
    )
}