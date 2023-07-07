package com.example.movieTicket.composable


import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieTicket.screens.buyTicketsScreen.ChairState
import com.example.movieticketsv2.R
import com.example.movieticketsv2.ui.theme.Orange
import com.example.movieticketsv2.ui.theme.White

@Composable
fun ChairItem(
    chairState: ChairState,
    modifier: Modifier = Modifier,
    ocClickChair: (ChairState) -> Unit,){
    IconButton(
    onClick = { ocClickChair(chairState) },
    modifier = modifier,
) {
    Icon(
        painter = painterResource(id = R.drawable.seat),
        contentDescription = null,
        modifier = modifier,
        tint = when(chairState){
            ChairState.AVAILABLE-> LightGray
            ChairState.BOCKED-> Orange
            else -> White
        }
    )
}
}
@Preview
@Composable
fun ChairItemPreview(){
    ChairItem(chairState = ChairState.BOCKED, modifier = Modifier.size(75.dp)){}
}
