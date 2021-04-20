package com.captaindeer.myinstagram.data.remote

import com.captaindeer.myinstagram.data.remote.responses.PostResponse
import com.captaindeer.myinstagram.data.remote.services.PostService
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val client = OkHttpClient.Builder().build()

    private lateinit var postService: PostService

    private val  retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://607a24acbd56a60017ba27ff.mockapi.io/aprendev/")
        .addConverterFactory(GsonConverterFactory.create()).client(client).build()

    fun getPosts(): Call<ArrayList<PostResponse>>{
        postService = retrofit.create(PostService::class.java)
        return postService.getPosts()
    }

}