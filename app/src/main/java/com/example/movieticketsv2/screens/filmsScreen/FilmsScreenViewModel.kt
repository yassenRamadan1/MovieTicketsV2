package com.example.movieTicket.screens.filmsScreen

import androidx.lifecycle.ViewModel
import com.example.movieTicket.screens.buyTicketsScreen.BuyTicketsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class FilmsScreenViewModel :ViewModel() {
    private val _filmsState = MutableStateFlow(FilmsUiState())
    val filmsState = _filmsState.asStateFlow()


}