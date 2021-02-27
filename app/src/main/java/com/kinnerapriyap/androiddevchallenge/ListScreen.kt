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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import dev.chrisbanes.accompanist.glide.GlideImage

@ExperimentalFoundationApi
@Composable
fun ListScreen(openDetail: (item: PawItem) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Title() },
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = contentColorFor(backgroundColor = MaterialTheme.colors.surface)
            )
        }
    ) {
        LazyVerticalGrid(cells = GridCells.Fixed(2)) {
            items(list) {
                ListItem(item = it, openDetail = openDetail)
            }
        }
    }
}

@Composable
fun ListItem(item: PawItem, openDetail: (item: PawItem) -> Unit) {
    GlideImage(
        data = item.imageUrl,
        modifier = Modifier
            .padding(20.dp)
            .clickable { openDetail.invoke(item) },
        contentDescription = item.name,
        requestBuilder = {
            apply(RequestOptions().override(500).circleCrop())
        }
    )
}
