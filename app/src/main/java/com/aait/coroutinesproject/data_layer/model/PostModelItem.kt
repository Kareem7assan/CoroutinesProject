package com.aait.coroutinesproject.data_layer.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PostModelItem(
    @SerializedName("body")
    val body: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("userId")
    val userId: String?
):Serializable