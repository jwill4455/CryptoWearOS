package com.example.cryptowearos.presentation.ui.exchangerate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text

@Composable
fun ExchangeRateScreen(viewModel: ExchangeRateViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        state.currentRate?.let { rate ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Current BTC/EUR:",
                    style = MaterialTheme.typography.body1.copy(
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "$rate",
                    style = MaterialTheme.typography.body1.copy(
                        color = MaterialTheme.colors.primary
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
        state.error?.let { error ->
            Text(
                text = "Error: $error",
                style = MaterialTheme.typography.body2.copy(
                    color = MaterialTheme.colors.error
                ),
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
