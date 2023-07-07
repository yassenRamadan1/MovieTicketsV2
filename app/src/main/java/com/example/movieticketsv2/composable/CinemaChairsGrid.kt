package com.example.movieTicket.composable


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieTicket.screens.buyTicketsScreen.BuyTicketsUiState
import com.example.movieticketsv2.R

@Composable
fun CinemaChairsGrid(buyTicketsUiState: BuyTicketsUiState,
                     modifier: Modifier = Modifier,
                     onClickChair: () -> Unit,){
    val list = (1..15).map { it.toString() }
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        // content padding
        contentPadding = PaddingValues(
            start = 8.dp,
            end = 8.dp,
        ),
        content = {
            items(list.size) { index ->
                Box(
                    modifier = Modifier
                        .wrapContentSize()
                        .graphicsLayer {
                            val rotateDegree = when (index) {
                                0, 3, 6, 9, 12 -> 10f
                                1, 4, 7, 10, 13 -> 0f
                                else -> {
                                    -10f
                                }
                            }
                            val translatedY = when (index) {
                                1, 4, 7, 10, 13 -> 30f
                                else -> 0f
                            }
                            rotationZ = rotateDegree
                            translationY = translatedY
                        },
                ) {
                    CinemaChairsItem(buyTicketsUiState = buyTicketsUiState) {

                    }
                }
            }
        }
    )
}
@Composable
fun CinemaChairsItem(
    buyTicketsUiState: BuyTicketsUiState,
    modifier: Modifier = Modifier,
    onClickChair: () -> Unit, ){
    Box(modifier = modifier.height(60.dp), contentAlignment = Alignment.Center) {
        Icon(painter = painterResource(id = R.drawable.container)
            ,contentDescription ="",
            modifier= Modifier.size(94.dp),
            tint = LightGray.copy(alpha = 0.38f)
        )
        Row(modifier = Modifier.padding(bottom = 8.dp, start = 2.dp)) {
            ChairItem(chairState = buyTicketsUiState.chairState
                , modifier = Modifier.size(34.dp)){
                onClickChair
            }
            ChairItem(chairState = buyTicketsUiState.chairState, modifier = Modifier.size(34.dp)){
                onClickChair
            }
        }
    }

    }
@Preview
@Composable
fun ShowLayout(){
    CinemaChairsGrid(buyTicketsUiState = BuyTicketsUiState()){

    }
}
@Preview
@Composable
fun CinemaChairsItemPreview(){
    CinemaChairsItem(buyTicketsUiState = BuyTicketsUiState(),){

    }
}