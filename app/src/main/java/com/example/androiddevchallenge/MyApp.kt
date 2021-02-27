package com.example.androiddevchallenge

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.Destinations.Detail
import com.example.androiddevchallenge.Destinations.DetailArgs.PawItemImageUrl
import com.example.androiddevchallenge.Destinations.DetailArgs.PawItemName

@ExperimentalFoundationApi
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }
    Surface(color = MaterialTheme.colors.background) {
        NavHost(navController = navController, startDestination = "list") {
            composable("list") {
                ListScreen(actions.openDetail)
            }
            composable(
                "$Detail/name={$PawItemName}&imageUrl={$PawItemImageUrl}",
                arguments = listOf(
                    navArgument(PawItemName) { type = NavType.StringType },
                    navArgument(PawItemImageUrl) { type = NavType.StringType }
                )
            ) {
                DetailScreen(
                    item = PawItem(
                        imageUrl = it.arguments?.getString(PawItemImageUrl) ?: "",
                        name = it.arguments?.getString(PawItemName) ?: ""
                    ),
                    navigateBack = actions.navigateBack
                )
            }
        }
    }
}