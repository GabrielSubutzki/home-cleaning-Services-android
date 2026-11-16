package com.example.cleaningservicesapp.ui.theme.Home
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// 1. Data class que representa o "Estado da Tela" (UI State)
data class HomeUiState(
    val selectedTab: Int = 0, // Guarda a aba atual aqui
    val userName: String = "Gabriel Subutzki"
)

class HomeViewModel : ViewModel() {

    // 2. Estado mutável privado (só o ViewModel pode alterar)
    private val _uiState = MutableStateFlow(HomeUiState())

    // 3. Estado imodificável público (a View apenas observa)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        // Quando o ViewModel é criado, já disparamos a busca de dados
        loadServices()
    }
    fun onTabSelected(index: Int) {
        _uiState.value = _uiState.value.copy(selectedTab = index)
    }
    fun loadServices() {
        // Ativa o estado de carregamento
        _uiState.value = _uiState.value.copy()


    }
}



