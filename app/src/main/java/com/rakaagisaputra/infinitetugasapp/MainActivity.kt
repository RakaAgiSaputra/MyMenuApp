package com.rakaagisaputra.infinitetugasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.rakaagisaputra.infinitetugasapp.screen.MenuApp
import com.rakaagisaputra.infinitetugasapp.ui.theme.InfiniteTugasAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val selectedTab = remember { mutableStateOf("home") }
    val appBarTitle = remember { mutableStateOf("Home") } // State untuk judul AppBar

    InfiniteTugasAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = appBarTitle.value) },
                    navigationIcon = {
                        if (appBarTitle.value == "Detail Menu") {
                            IconButton(onClick = { navController.popBackStack() }) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        // Home Tab
                        BottomBarItem(
                            isSelected = selectedTab.value == Screen.HomeScreen.route,
                            icon = Icons.Default.Home,
                            label = "Home",
                            onClick = {
                                selectedTab.value = "home"
                                navController.navigate(Screen.HomeScreen.route)
                            }
                        )

                        // List Tab
                        BottomBarItem(
                            isSelected = selectedTab.value == "list",
                            icon = Icons.Default.List,
                            label = "List",
                            onClick = {
                                selectedTab.value = "list"
                                navController.navigate(Screen.MenuScreen.route)
                            }
                        )

                        // Favorite Tab
                        BottomBarItem(
                            isSelected = selectedTab.value == "favorite",
                            icon = Icons.Default.Favorite,
                            label = "Favorite",
                            onClick = {
                                selectedTab.value = "favorite"
                                navController.navigate(Screen.FavoriteScreen.route)
                            }
                        )

                        // Profile Tab
                        BottomBarItem(
                            isSelected = selectedTab.value == "profile",
                            icon = Icons.Default.AccountCircle,
                            label = "Profile",
                            onClick = {
                                selectedTab.value = "profile"
                                navController.navigate(Screen.ProfileScreen.route)
                            }
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->
            MenuApp(
                navController,
                paddingValue = paddingValues,
                updateAppBar = { appBarTitle.value = it })
        }
    }
}

@Composable
fun BottomBarItem(
    isSelected: Boolean,
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) Color.Transparent else Color.Transparent
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(corner = CornerSize(10.dp)))
            .clickable(onClick = onClick)
            .padding(6.dp)
            .background(backgroundColor)
            .aspectRatio(1f)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(36.dp)
        )
        Text(label, textAlign = TextAlign.Center)
    }
}