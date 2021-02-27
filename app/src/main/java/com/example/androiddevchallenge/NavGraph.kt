package com.example.androiddevchallenge

import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.Destinations.Detail

object Destinations {
    const val List = "list"
    const val Detail = "detail"

    object DetailArgs {
        const val PawItemName = "pawItemName"
        const val PawItemImageUrl = "pawItemImageUrl"
    }
}

class Actions(navController: NavHostController) {
    val openDetail: (item: PawItem) -> Unit = { item ->
        navController.navigate("$Detail/name=${item.name}&imageUrl=${item.imageUrl}")
    }
    val navigateBack: () -> Unit = {
        navController.popBackStack()
    }
}