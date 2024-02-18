package com.example.mytodoapplication.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun TodoNavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.ON_BOARDING_SCREEN_1) {

        composable(Routes.ON_BOARDING_SCREEN_1) {
            OnBoardingScreen1(navController, currentPage = 0)
        }

        composable(Routes.ON_BOARDING_SCREEN_2) {
            OnBoardingScreen2(navController, currentPage = 1)
        }

        composable(Routes.ON_BOARDING_SCREEN_3) {
            OnBoardingScreen3(navController, currentPage = 2)
        }

        composable(Routes.ON_BOARDING_SCREEN_4) {
            OnBoardingScreen4(navController)
        }

        composable(Routes.LOGIN_SCREEN) {
            LoginScreen(navController)
        }

        composable(Routes.REGISTRATION_SCREEN) {
            RegistrationScreen(navController)
        }
    }
}