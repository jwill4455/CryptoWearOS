package com.example.cryptowearos.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptowearos.presentation.ui.exchangerate.ExchangeRateScreen

@Composable
fun NavigationSetup() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "exchange_rate_screen") {
        composable("exchange_rate_screen") {
            ExchangeRateScreen()
        }
    }
}