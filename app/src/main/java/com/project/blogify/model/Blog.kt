package com.project.blogify.model

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val id: Long,
    val date: String,
    val link: String,
    val title: Title,
    val author: Long
)

@Serializable
data class Title(
    val rendered: String
)
