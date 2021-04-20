package com.captaindeer.myinstagram.data.remote.responses

import androidx.annotation.NonNull
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName(value = "id") val id: Int,
    @SerializedName(value = "title") val title: String,
    @SerializedName(value = "description") val description: String,
    @SerializedName(value = "image") val image: String
)