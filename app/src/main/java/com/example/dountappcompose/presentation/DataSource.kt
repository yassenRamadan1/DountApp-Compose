package com.example.dountappcompose.presentation


import com.example.dountappcompose.R
import com.example.dountappcompose.presentation.home.DonutsUiState
import com.example.dountappcompose.ui.theme.White
import com.example.dountappcompose.ui.theme.light_blue
import com.example.dountappcompose.ui.theme.light_pink

object DataSource {
    fun donutsData(): List<DonutsUiState> {
        return listOf(
            DonutsUiState(
                0
                ,R.drawable.black_donut_main_card
                ,"Strawberry Wheel"
                ,"These soft, cake-like Strawberry Frosted Donuts feature fresh strawberries and a delicious fresh strawberry glaze frosting. Pretty enough for company and the perfect treat to satisfy your sweet tooth."
                ,20
                ,16
                , light_blue
            ),
            DonutsUiState(
                1
                ,R.drawable.pink_donut_main_card
                ,"Chocolate Glaze"
                ,"Moist and fluffy baked chocolate donuts full of chocolate flavor."
                ,20
                ,16
                , light_pink
            ) ,
            DonutsUiState(
                2
                ,R.drawable.che_secodary_card
                ,"Chocolate Cherry"
                ,""
                ,22
                ,22
                , White
            ),
            DonutsUiState(
                3
                ,R.drawable.chips_secondary_card
                ,"Strawberry Rain"
                ,""
                ,22
                ,22
                , White
            ),
            DonutsUiState(
                4
                ,R.drawable.pink_secodary_card
                ,"Strawberry Wheel"
                ,"These Baked Strawberry Donuts are filled with fresh strawberries..."
                ,20
                ,16
                , White
            ),
            DonutsUiState(
                5
                ,R.drawable.pink_donut_main_card
                ,"Strawberry "
                ,""
                ,22
                ,22
                , White
            ),DonutsUiState(
                6
                ,R.drawable.pink_donut_main_card
                ,"Strawberry Wheel"
                ,"These Baked Strawberry Donuts are filled with fresh strawberries..."
                ,20
                ,16
                , White
            )
        )
    }

}