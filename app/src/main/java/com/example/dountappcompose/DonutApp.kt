package com.example.dountappcompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.dountappcompose.composable.CustomBottomNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonutApp (
    navController:NavHostController
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: Screens.Home.route
    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute == Screens.Home.route,
                enter =  slideInVertically() + fadeIn(),
                exit = slideOutVertically { it } + fadeOut()
            ) {
                CustomBottomNav()
            }
        },
    ){
        DonutNavGraph(navController = navController,it)
    }
}