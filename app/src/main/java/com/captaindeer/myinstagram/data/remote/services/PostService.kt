package com.captaindeer.myinstagram.data.remote.services

import com.captaindeer.myinstagram.data.remote.responses.PostResponse
import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET(value = "posts")
    fun getPosts(): Call<ArrayList<PostResponse>>

}