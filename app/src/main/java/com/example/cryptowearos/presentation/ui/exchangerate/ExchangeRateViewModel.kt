package com.example.cryptowearos.presentation.ui.exchangerate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptowearos.domain.repository.ExchangeRateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeRateViewModel @Inject constructor(
    private val repository: ExchangeRateRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ExchangeRateState())
    val state: StateFlow<ExchangeRateState> get() = _state

    init {
        fetchCurrentExchangeRate()
    }

    private fun fetchCurrentExchangeRate() {
        viewModelScope.launch {
            try {
                repository.getCurrentExchangeRate().collect { rate ->
                    _state.value = ExchangeRateState(currentRate = rate)
                }
            } catch (e: Exception) {
                _state.value = ExchangeRateState(error = e.message)
            }
        }
    }
}