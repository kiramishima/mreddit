package net.kiramishima.app.mreddit.data.repository

import androidx.lifecycle.LiveData
import net.kiramishima.app.mreddit.domain.model.PostModel

interface Repository {

  fun getAllPosts(): LiveData<List<PostModel>>

  fun getAllOwnedPosts(): LiveData<List<PostModel>>

  fun insert(post: PostModel)

  fun deleteAll()
}