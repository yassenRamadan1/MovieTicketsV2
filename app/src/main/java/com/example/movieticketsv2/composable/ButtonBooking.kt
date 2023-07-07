package com.example.movieTicket.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieticketsv2.R
import com.example.movieticketsv2.ui.theme.Orange
import com.example.movieticketsv2.ui.theme.White

@Composable
fun ButtonBooking(stringId: Int, width: Int, onClickEvent: () -> Unit) {
    Button(
        onClick = onClickEvent, modifier = Modifier
            .size(width.dp, 50.dp)
            .background(
                Orange, RoundedCornerShape(24.dp)
            ), colors = ButtonDefaults.buttonColors(
            Orange
        )
    ) {
        Icon(
            imageVector = Icons.Default.CalendarToday,
            contentDescription = stringResource(R.string.booking),
            tint = White,
            modifier = Modifier.background(Orange)
        )
        Text(
            text = stringResource(stringId),
            fontSize = 14.sp,
            color = White,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}