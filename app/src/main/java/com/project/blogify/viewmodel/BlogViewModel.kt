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

    private var currentPage = 1
    private val perPage = 10
    private var isLoadingMore = false
    private var isLastPage = false

    private val _posts = MutableStateFlow<UiState<List<Post>>>(UiState.Loading)
    val posts: StateFlow<UiState<List<Post>>> = _posts

    private val loadedPosts = mutableListOf<Post>()

    init {
        loadPosts()
    }

    fun loadPosts() {
        // Prevent duplicate loads
        if (isLoadingMore || isLastPage) return

        isLoadingMore = true
        viewModelScope.launch {
            try {
                val result = postService.fetchPosts(page = currentPage, perPage = perPage)
                if (result.isNotEmpty()) {
                    loadedPosts.addAll(result)
                    _posts.value = UiState.Success(loadedPosts.toList())
                    currentPage++
                } else {
                    isLastPage = true
                }
            } catch (e: Exception) {
                _posts.value = UiState.Error("Please check your internet connection and try again")
                Log.d("error", e.localizedMessage ?: "error")
            } finally {
                isLoadingMore = false
            }
        }
    }

    fun reload() {
        _posts.value = UiState.Loading
        loadPosts()
    }
}