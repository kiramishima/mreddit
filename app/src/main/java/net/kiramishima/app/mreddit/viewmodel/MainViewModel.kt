package net.kiramishima.app.mreddit.viewmodel

import androidx.lifecycle.ViewModel
import net.kiramishima.app.mreddit.data.repository.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {
    val allPosts by lazy { repository.getAllPosts() }

    val myPosts by lazy { repository.getAllOwnedPosts() }
}