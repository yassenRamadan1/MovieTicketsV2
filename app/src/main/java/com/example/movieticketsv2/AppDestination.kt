package com.example.movieTicket

sealed class AppDestination(val route : String) {
    object FilmsScreen : AppDestination("filmsScreen")
    object BookingScreen : AppDestination("bookingScreen")
    object BuyTicketsScreen : AppDestination("buyTicketsScreen")
}