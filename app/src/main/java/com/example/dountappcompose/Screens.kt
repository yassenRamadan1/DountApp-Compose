package com.example.dountappcompose

sealed class Screens(val route: String) {
    object Details : Screens("details")
    object OnBoarding : Screens("on_boarding")
    object Home : Screens("home")
}