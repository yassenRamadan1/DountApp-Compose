package com.example.dountappcompose.presentation.home

import androidx.lifecycle.ViewModel
import com.example.dountappcompose.presentation.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class HomeViewModel  :ViewModel(){
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        getDonuts()
    }

    private fun getDonuts() {
        _state.update{it.copy(donuts = DataSource.donutsData())}
    }

}