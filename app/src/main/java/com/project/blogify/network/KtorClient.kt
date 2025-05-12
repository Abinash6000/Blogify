package com.project.blogify.network

import com.project.blogify.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {
    val httpClient = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true // Makes the JSON output easier to read
                isLenient = true // Allows some flexibility in the JSON format (e.g., accepting single quotes).
                ignoreUnknownKeys = true // Ignores any unknown fields in the response JSON
            })
        }
    }
}

interface PostService {
    suspend fun fetchPosts(page: Int, perPage: Int): List<Post>
}

class PostServiceImpl(private val client: HttpClient) : PostService {

    override suspend fun fetchPosts(page: Int, perPage: Int): List<Post> {
        return client.get("https://blog.vrid.in/wp-json/wp/v2/posts?per_page=$perPage&page=$page").body()
    }
}
