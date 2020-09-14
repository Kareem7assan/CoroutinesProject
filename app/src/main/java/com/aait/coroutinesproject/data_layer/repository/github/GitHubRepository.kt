package com.aait.coroutinesproject.data_layer.repository.github

import com.aait.coroutinesproject.data_layer.model.PostModel
import com.aait.coroutinesproject.data_layer.model.Result


interface GitHubRepository {
suspend fun getPosts(): Result<PostModel>

}