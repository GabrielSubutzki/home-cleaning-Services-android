package com.example.cleaningservicesapp.ui.login // Ajuste para o seu package real

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// 1. Estado da tela de Login
data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isLoginSuccess: Boolean = false
)

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    // Atualiza o email quando o utilizador digita
    fun onEmailChanged(newEmail: String) {
        _uiState.value = _uiState.value.copy(email = newEmail, errorMessage = null)
    }

    // Atualiza a password quando o utilizador digita
    fun onPasswordChanged(newPassword: String) {
        _uiState.value = _uiState.value.copy(password = newPassword, errorMessage = null)
    }

    // Ação executada ao clicar no botão de Entrar
    fun login() {
        val currentState = _uiState.value

        // Validação simples
        if (currentState.email.isBlank() || currentState.password.isBlank()) {
            _uiState.value = currentState.copy(errorMessage = "Preencha todos os campos")
            return
        }

        // Ativa o carregamento
        _uiState.value = currentState.copy(isLoading = true, errorMessage = null)

        // Aqui futuramente fará a chamada ao seu repositório/Firebase/API.
        // Simulamos uma resposta bem-sucedida após alguns segundos ou de forma imediata:
        _uiState.value = currentState.copy(
            isLoading = false,
            isLoginSuccess = true
        )
    }
}