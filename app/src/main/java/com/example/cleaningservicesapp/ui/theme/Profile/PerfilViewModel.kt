package com.example.cleaningservicesapp.ui.theme.Profile



import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ProfileUiState(
    val name: String = "Eduardo Subutzki",
    val email: String = "eduardo@email.com",
    val phone: String = "+55 71 99999-9999"
)

class ProfileViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()
}