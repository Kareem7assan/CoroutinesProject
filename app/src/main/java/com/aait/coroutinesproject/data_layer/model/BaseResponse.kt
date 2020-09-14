package com.aait.coroutinesproject.data_layer.model


import java.io.Serializable

open class BaseResponse(
    val key: String?="",
    val msg: String?="",
    val code: Int?=200,
    val user_status:String?="active",
    val value: String?="1"
):Serializable
