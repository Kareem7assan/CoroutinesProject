package com.aait.coroutinesproject.data_layer.repository.github

import com.aait.coroutinesproject.data_layer.cache.PreferencesGateway
import com.aait.coroutinesproject.data_layer.model.PostModel
import com.aait.coroutinesproject.data_layer.model.Result
import com.aait.coroutinesproject.data_layer.model.getData
import com.aait.coroutinesproject.data_layer.remote.GitHubApis
import javax.inject.Inject

class GitHubRepositoryImpl  @Inject constructor(
    private val githubApi: GitHubApis ,
    private val preferences: PreferencesGateway
):GitHubRepository{
    override suspend fun getPosts(): Result<PostModel> {
        return githubApi.getPosts().getData()
    }
}