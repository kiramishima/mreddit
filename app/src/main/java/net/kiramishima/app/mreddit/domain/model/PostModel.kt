package net.kiramishima.app.mreddit.domain.model

import net.kiramishima.app.mreddit.R

data class PostModel(
  val username: String,
  val subreddit: String,
  val title: String,
  val text: String,
  val likes: String,
  val comments: String,
  val type: PostType,
  val postedTime: String,
  val image: Int?
) {

  companion object {

    val DEFAULT_POST = PostModel(
      "zero_mishima",
      "androiddev",
      "Watch this awesome Jetpack Compose course!",
      "",
      "5614",
      "523",
      PostType.IMAGE,
      "4h",
      R.drawable.compose_course
    )
  }
}