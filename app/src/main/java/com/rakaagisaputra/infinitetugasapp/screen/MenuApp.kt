package com.rakaagisaputra.infinitetugasapp.screen

import DetailMenuScreen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rakaagisaputra.infinitetugasapp.Screen
import com.rakaagisaputra.infinitetugasapp.data.Category
import com.rakaagisaputra.infinitetugasapp.model.MainViewModel

@Composable
fun MenuApp(navController: NavController, paddingValue: PaddingValues, updateAppBar: (String) -> Unit) {
    val menuViewModel: MainViewModel = viewModel()
    val viewState by menuViewModel.categoryState

    NavHost(navController as NavHostController, startDestination = Screen.HomeScreen.route) {
        // Menu Screen
        composable(route = Screen.MenuScreen.route) {
            updateAppBar("Menu")
            MenuScreen(
                pd = paddingValue,
                viewState = viewState,
                navigateToDetail = { category ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("cat", category)
                    navController.navigate(Screen.DetailMenuScreen.route)
                }
            )
        }

        // Detail Menu Screen
        composable(route = Screen.DetailMenuScreen.route) {
            updateAppBar("Detail Menu")
            val category = navController.previousBackStackEntry
                ?.savedStateHandle
                ?.get<Category>("cat") ?: Category("", "", "", "")
            DetailMenuScreen(navController, category = category)
        }

        // Home Screen
        composable(route = Screen.HomeScreen.route) {
            updateAppBar("Home")
            // Mengambil data kategori dari ViewModel
            val viewModel: MainViewModel = viewModel()
            val state by viewModel.categoryState

            Box(modifier = Modifier.fillMaxSize().padding(paddingValue)){
                when {
                    state.loading -> {
                        // Tampilkan indikator loading saat data sedang dimuat
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                    state.error != null -> {
                        // Tampilkan pesan error jika terjadi masalah
                        Text(
                            text = state.error ?: "Error tidak diketahui",
                            color = Color.Red,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    else -> {
                        // Tampilkan HomeScreen dengan daftar kategori
                        HomeScreen(categories = state.list)
                    }
                }
            }

        }

        // Favorite Screen
        composable(route = Screen.FavoriteScreen.route) {
            updateAppBar("Favorite")
            FavoriteScreen()
        }

        // Profile Screen
        composable(route = Screen.ProfileScreen.route) {
            updateAppBar("Profile")

            Box(modifier = Modifier.padding(paddingValue)){
                ProfileScreen()
            }
        }
    }
}