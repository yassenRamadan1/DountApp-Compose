package com.example.dountappcompose.presentation.home

import androidx.compose.ui.graphics.Color

data class HomeUiState (
    val donuts: List<DonutsUiState> = emptyList()
)
    data class DonutsUiState(
        val id: Int
        , val imageRef: Int
        , val donutNme:String
        , val donutBody:String
        , val priceAfterOffer:Int
        , val price:Int
        ,val color: Color)