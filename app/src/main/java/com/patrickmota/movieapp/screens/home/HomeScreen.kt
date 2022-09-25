package com.patrickmota.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.patrickmota.movieapp.MovieRow
import com.patrickmota.movieapp.navigation.MovieScreens

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color.Magenta, elevation = 5.dp) {
                Text(text = "Movies")
            }
        }
    ) { padding ->
        MainContent(navController = navController, padding = padding)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    padding: PaddingValues = PaddingValues(12.dp),
    movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Harry Potter",
        "Life",
        "Cross the Line...",
        "Be harry...",
        "Happy feet...",
        "Happiness..."
    )
) {
    Column(modifier = Modifier.padding(padding)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailScreen.name + "/$movie")
                }
            }
        }
    }
}
