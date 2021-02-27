/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kinnerapriyap.androiddevchallenge

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
import com.kinnerapriyap.androiddevchallenge.Destinations.Detail
import com.kinnerapriyap.androiddevchallenge.Destinations.DetailArgs.PawItemImageUrl
import com.kinnerapriyap.androiddevchallenge.Destinations.DetailArgs.PawItemName

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
