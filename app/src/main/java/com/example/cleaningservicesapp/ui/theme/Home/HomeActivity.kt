package com.example.cleaningservicesapp.ui.home

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
import com.example.cleaningservicesapp.ui.theme.Home.HomeViewModel

class HomeActivity : ComponentActivity() {

    companion object {
        fun navigate(ctx: Context) {
            val intent = Intent(ctx, HomeActivity::class.java)
            ctx.startActivity(intent)
        }
    }

    // 1. Instancia o ViewModel aqui na Activity
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 2. Passa o viewModel para dentro da HomeScreen
                    HomeScreen(viewModel = viewModel)
                }
            }
        }
    }
}