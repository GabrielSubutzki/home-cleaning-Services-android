package com.example.cleaningservicesapp // Ajuste para o seu package

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

import com.example.cleaningservicesapp.ui.theme.Login.LoginActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 1. Navega imediatamente para a HomeActivity
        LoginActivity.navigate(this)
        // 2. Fecha a MainActivity para ela não ficar no histórico de telas
        finish()
    }
}