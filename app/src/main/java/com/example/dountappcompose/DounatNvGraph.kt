package com.example.dountappcompose


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dountappcompose.presentation.details.DetailsScreen
import com.example.dountappcompose.presentation.home.HomeScreen
import com.example.dountappcompose.presentation.onBoarding.OnBoardingScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonutNavGraph(navController: NavHostController,paddingValues: PaddingValues){
        NavHost(navController = navController, startDestination = Screens.OnBoarding.route) {
            composable(Screens.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(Screens.Details.route) {
                DetailsScreen(navController = navController)
            }
            composable(Screens.OnBoarding.route) {
                OnBoardingScreen(navController = navController)
            }
        }

}