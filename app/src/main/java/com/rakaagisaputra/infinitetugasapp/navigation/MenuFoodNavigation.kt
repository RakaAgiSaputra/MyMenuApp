package com.rakaagisaputra.infinitetugasapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rakaagisaputra.infinitetugasapp.screen.MenuSpalashScreen


@Composable
fun MenuFoodNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MenuFoodScreens.SplashScreen.name ){
        composable(MenuFoodScreens.SplashScreen.name){
            MenuSpalashScreen(navController)
        }

    }
}

