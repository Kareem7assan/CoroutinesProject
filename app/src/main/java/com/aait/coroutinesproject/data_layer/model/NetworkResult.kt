package com.aait.coroutinesproject.data_layer.model

import retrofit2.Response
import java.io.IOException



inline fun <T : Any> Response<T>.onSuccess(action: (T) -> Unit): Response<T> {
    val resp = body() as BaseResponse
    if (isSuccessful && resp.value=="1") {
        body()?.run(action)
    }

    return this
}

inline fun <T : Any> Response<T>.onFailure(action: (HttpError) -> Unit) {
    val resp=body() as BaseResponse
    if (!isSuccessful) errorBody()?.run {
        action(HttpError(Throwable(message()), code()))
    }
    else if (resp.value!="1") {
        action(HttpError(Throwable(), resp.value!!.toInt()))
    }




}
fun <T:Any> Response<T>.getData():Result<T>{
    try {
        onSuccess { return Success(it) }
        onFailure { return Failure(it) }
        return Failure(HttpError(Throwable()))
    } catch (e: IOException) {
        return Failure(HttpError(Throwable()))
    }
}