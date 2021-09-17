package net.kiramishima.app.mreddit.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kiramishima.app.mreddit.components.ImagePost
import net.kiramishima.app.mreddit.components.JoinedToast
import net.kiramishima.app.mreddit.components.TextPost
import net.kiramishima.app.mreddit.domain.model.PostModel
import net.kiramishima.app.mreddit.domain.model.PostType
import net.kiramishima.app.mreddit.viewmodel.MainViewModel
import java.util.*
import kotlin.concurrent.schedule

@ExperimentalAnimationApi
@Composable
fun HomeScreen(viewModel: MainViewModel) {
    val posts: List<PostModel> by viewModel.allPosts.observeAsState(listOf())

    var isToastVisible by remember { mutableStateOf(false) }

    val onJoinClickAction: (Boolean) -> Unit = { joined ->
        isToastVisible = joined
        if (isToastVisible) {
            Timer().schedule(3000) {
                isToastVisible = false
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.background(color = MaterialTheme.colors.secondary)) {
            items(posts) {
                if (it.type == PostType.TEXT) {
                    TextPost(it, onJoinButtonClick = onJoinClickAction)
                } else {
                    ImagePost(it, onJoinButtonClick = onJoinClickAction)
                }
                Spacer(modifier = Modifier.height(6.dp))
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        ) {
            JoinedToast(visible = isToastVisible)
        }
    }


}