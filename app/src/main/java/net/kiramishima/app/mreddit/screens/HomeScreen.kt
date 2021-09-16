package net.kiramishima.app.mreddit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kiramishima.app.mreddit.components.ImagePost
import net.kiramishima.app.mreddit.components.TextPost
import net.kiramishima.app.mreddit.domain.model.PostModel
import net.kiramishima.app.mreddit.domain.model.PostType
import net.kiramishima.app.mreddit.viewmodel.MainViewModel

@Composable
fun HomeScreen(viewModel: MainViewModel) {
    val posts: List<PostModel> by viewModel.allPosts.observeAsState(listOf())

    LazyColumn(modifier = Modifier.background(color = MaterialTheme.colors.secondary)) {
        items(posts) {
            if (it.type == PostType.TEXT) {
                TextPost(it)
            } else {
                ImagePost(it)
            }
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}