package com.rakaagisaputra.infinitetugasapp

sealed class Screen(val route: String){
    object MenuScreen:Screen(route = "menuscreen")
    object DetailMenuScreen:Screen(route = "detailmenuscreen")
    object HomeScreen:Screen("home")
    object FavoriteScreen:Screen("favorite")
    object ProfileScreen:Screen("profile")
}