package com.project.blogify.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.blogify.model.Post
import com.project.blogify.network.KtorClient
import com.project.blogify.network.PostService
import com.project.blogify.network.PostServiceImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BlogViewModel : ViewModel() {
    private val httpClient = KtorClient.httpClient
    private val postService: PostService = PostServiceImpl(httpClient)

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    init {
        viewModelScope.launch {
            try {
                _posts.value = postService.fetchPosts()
            } catch (e: Exception) {
                Log.d("abcdef", e.toString())
            }
        }
    }
}