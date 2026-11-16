package com.example.cleaningservicesapp.ui.theme.Login

import com.example.cleaningservicesapp.ui.login.LoginScreen
import com.example.cleaningservicesapp.ui.login.LoginViewModel



import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cleaningservicesapp.ui.home.HomeActivity


class LoginActivity : ComponentActivity() {

    companion object {
        fun navigate(ctx: Context) {
            val intent = Intent(ctx, LoginActivity::class.java)
            ctx.startActivity(intent)
        }
    }

    // Instancia o ViewModel usando a delegação padrão (ou o seu viewModelInit se precisar de parâmetros)
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(
                        viewModel = viewModel,
                        onLoginSuccess = {
                            // Quando o login for bem-sucedido, abre a HomeActivity e fecha o Login
                            HomeActivity.navigate(this)
                            finish()
                        }
                    )
                }
            }
        }
    }
}