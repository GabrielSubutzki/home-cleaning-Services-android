package com.example.cleaningservicesapp.ui.home
import androidx.compose.material3.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cleaningservicesapp.ui.theme.Home.HomeViewModel
import com.example.cleaningservicesapp.ui.theme.booking.BookingScreen
import com.example.cleaningservicesapp.ui.theme.booking.BookingViewModel

import com.example.cleaningservicesapp.ui.theme.Profile.ProfileScreen
import com.example.cleaningservicesapp.ui.theme.Profile.ProfileViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    // Observa o estado diretamente do ViewModel
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "ED", fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onPrimaryContainer)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(text = "Bem-vindo de volta,", fontSize = 12.sp, color = Color.Gray)
                        Text(text = uiState.userName, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }
                }

                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notificações")
                }
            }
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = uiState.selectedTab == 0,
                    onClick = { viewModel.onTabSelected(0) } // Avisa o ViewModel
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.DateRange, contentDescription = "Booking") },
                    label = { Text("Booking") },
                    selected = uiState.selectedTab == 1,
                    onClick = { viewModel.onTabSelected(1) } // Avisa o ViewModel
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                    label = { Text("Perfil") },
                    selected = uiState.selectedTab == 2,
                    onClick = { viewModel.onTabSelected(2) } // Avisa o ViewModel
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            // O conteúdo muda com base no estado guardado no ViewModel
            when (uiState.selectedTab) {
                0 -> Text(text = "🏠 Conteúdo da Tela Home / Serviços", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                1 -> BookingScreen(BookingViewModel())
                2 ->  ProfileScreen(ProfileViewModel())
            }
        }
    }
}