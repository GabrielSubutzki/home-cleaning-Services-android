package com.example.cleaningservicesapp.ui.theme.booking



import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class BookingUiState(
    val appointments: List<String> = listOf("Limpeza Residencial - 20/Nov", "Limpeza Pós-Obra - 02/Dez"),
    val isLoading: Boolean = false
)

class BookingViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(BookingUiState())
    val uiState: StateFlow<BookingUiState> = _uiState.asStateFlow()
}




