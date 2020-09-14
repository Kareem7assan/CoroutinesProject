package com.aait.coroutinesproject.di.hilt


import com.aait.coroutinesproject.data_layer.repository.github.GitHubRepository
import com.aait.coroutinesproject.data_layer.repository.github.GitHubRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class GitRepositoryModule {
    @Binds
    abstract fun providesGitHubRepo(gitHubRepository: GitHubRepositoryImpl): GitHubRepository

}