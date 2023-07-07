package com.example.movieTicket.screens.buyTicketsScreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.SimpleDateFormat
import java.util.Calendar
import javax.inject.Inject

class BuyTicketsViewModel : ViewModel() {
    private val _state = MutableStateFlow(BuyTicketsUiState())
    val state = _state.asStateFlow()
    init {
        getCurrentDay()
    }

    private fun getCurrentDay() {
        val calendar = Calendar.getInstance()
        val dayFormat = SimpleDateFormat("d").format(calendar.time).toInt()
        val reservationDays = mutableListOf<Int>()
        for (i in dayFormat..dayFormat + 6) {
            reservationDays.add(i)
        }
        _state.update { it.copy(reservationDays = reservationDays) }
    }

    fun onClickDay(index: Int) {
        _state.update { it.copy(selectedDay = index) }
    }

    fun onClickTime(index: Int) {
        _state.update { it.copy(selectedTime = index) }
    }
    fun onClickChair() {

    }
}