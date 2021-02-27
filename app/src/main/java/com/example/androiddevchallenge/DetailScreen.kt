package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import com.example.androiddevchallenge.ui.theme.typography
import dev.chrisbanes.accompanist.glide.GlideImage

@Composable
fun DetailScreen(item: PawItem, navigateBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Title() },
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Back")
                    }
                },
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = contentColorFor(backgroundColor = MaterialTheme.colors.surface)
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                data = item.imageUrl,
                modifier = Modifier.padding(20.dp),
                contentDescription = item.name,
                requestBuilder = {
                    apply(RequestOptions().override(1000).centerCrop())
                })
            Text(text = item.name, style = typography.h4)

        }
    }
}

@Composable
fun Title() {
    Text(text = "The Paw Redoption")
}