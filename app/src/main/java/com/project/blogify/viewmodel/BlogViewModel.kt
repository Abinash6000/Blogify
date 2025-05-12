package com.project.blogify.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.blogify.model.Post
import com.project.blogify.network.KtorClient
import com.project.blogify.network.PostService
import com.project.blogify.network.PostServiceImpl
import com.project.blogify.ui.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class PostViewModel : ViewModel() {
    private val httpClient = KtorClient.httpClient
    private val postService: PostService = PostServiceImpl(httpClient)

    private val _posts = MutableStateFlow<UiState<List<Post>>>(UiState.Loading)
    val posts: StateFlow<UiState<List<Post>>> = _posts

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            try {
                val result = postService.fetchPosts()
                _posts.value = UiState.Success(result)
            } catch (e: Exception) {
                _posts.value = UiState.Error("Failed to load posts: ${e.localizedMessage}")
            }
        }
    }

    fun reload() {
        _posts.value = UiState.Loading
        loadPosts()
    }
}