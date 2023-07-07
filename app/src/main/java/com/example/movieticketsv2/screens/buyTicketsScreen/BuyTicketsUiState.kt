package com.example.movieTicket.screens.buyTicketsScreen

data class BuyTicketsUiState(
    val chairState: ChairState = ChairState.BOCKED,
    val chairNumber: Int = 0,
    val ticketPrice: Int = 0,
    val reservationDays: List<Int> = listOf(),
    val reservationTime : List<String> = listOf("10:00","12:30","15:30","18:30","21:00"),
    val selectedTime: Int = 0,
    val selectedDay: Int = 0
)
