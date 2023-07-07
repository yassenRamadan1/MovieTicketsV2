package com.example.movieTicket.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.example.movieTicket.screens.filmsScreen.FilmsUiState
import com.google.accompanist.pager.ExperimentalPagerApi
import androidx.compose.foundation.pager.HorizontalPager
import kotlin.math.absoluteValue
import androidx.compose.foundation.pager.PagerState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalFilmsPager(
    filmsUiState: FilmsUiState,
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onClickPhoto:()-> Unit
){
    val context = LocalContext.current
    val sliderList = filmsUiState.filmsPhotos
        HorizontalPager(
            pageCount =sliderList.size,
            state = pagerState,
            contentPadding = PaddingValues(start = 32.dp, end = 32.dp),
            pageSpacing = 16.dp,
            modifier = modifier.fillMaxWidth()

            ) { page ->
            Card(
                shape = RoundedCornerShape(32.dp),
                modifier = Modifier
                    .aspectRatio(4f / 5.9f)
                    .graphicsLayer {
                        val pageOffset = ((pagerState.currentPage - page)
                                + pagerState.currentPageOffsetFraction).absoluteValue
                        alpha = lerp(
                            start = 0.9f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )

                        scaleY = lerp(
                            start = 0.8f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
                    .clickable {
                        onClickPhoto()
                    }
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model =ImageRequest.Builder(context)
                    .data(sliderList[page])
                    .crossfade(true)
                    .scale(Scale.FIT)
                    .build(),
                    contentDescription =null,
                    contentScale = ContentScale.Fit,)
            }

        }


}
@OptIn(ExperimentalFoundationApi::class)
@ExperimentalPagerApi
@Preview
@Composable
fun PagerPreview(){
    HorizontalFilmsPager(FilmsUiState(), pagerState = PagerState()){

    }
}