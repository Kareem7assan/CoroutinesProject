package com.aait.coroutinesproject.data_layer.remote

import com.aait.coroutinesproject.data_layer.model.PostModel
import com.aait.coroutinesproject.data_layer.model.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface GitHubApis {
@GET("posts")
suspend fun getPosts():Response<PostModel>
}