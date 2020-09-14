package com.aait.coroutinesproject

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.aait.coroutinesproject.helper.Loading
import com.aait.coroutinesproject.helper.ViewState
import kotlinx.coroutines.*

open class ParentActivity:AppCompatActivity() {
    val scope= CoroutineScope(Dispatchers.Main+ Job())
    protected val _viewState = MutableLiveData<ViewState<Any>>()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }

    override fun onStop() {
        super.onStop()
        scope.cancel()
    }
    protected fun executeUseCase(action: suspend () -> Unit, noInternetAction: () -> Unit) {
        _viewState.value = Loading()
            scope.launch {
                action()
            }
        }
    protected fun executeApi(action: suspend () -> Unit) {
        _viewState.value = Loading()
            scope.launch {
                action()
            }
        }
    }


