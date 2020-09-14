package com.aait.coroutinesproject.ui

import android.os.Bundle
import com.aait.coroutinesproject.ParentActivity
import com.aait.coroutinesproject.R
import com.aait.coroutinesproject.data_layer.model.onFailure
import com.aait.coroutinesproject.data_layer.model.onSuccess
import com.aait.coroutinesproject.data_layer.repository.github.GitHubRepository
import com.aait.coroutinesproject.helper.Fail
import com.aait.coroutinesproject.helper.Success
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ParentActivity() {
    @Inject
    lateinit var repo:GitHubRepository



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMyPosts()
    }
fun getMyPosts() = executeApi  {
        repo.getPosts()
            .onSuccess {
                _viewState.value = Success(it)
            }.onFailure {
                _viewState.value = Fail(it.throwable)
            }
}

/*
    //val scope=CoroutineScope(Dispatchers.Main+ Job())
    private suspend fun getPosts() {
        try {
            val posts = repo.getPosts()
            Log.e("data",posts.toString())
           // Toast.makeText(applicationContext, "" + posts.size, Toast.LENGTH_SHORT).show()
        }
        catch (ex:Exception){
            print(ex.stackTrace)
            Log.e("error",ex.message)
        }*/

}
