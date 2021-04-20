package com.captaindeer.myinstagram.ui.home

import com.captaindeer.myinstagram.data.remote.RetrofitBuilder
import com.captaindeer.myinstagram.data.remote.responses.PostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(private val view: HomeInterface.View) :
    HomeInterface.Presenter {

    private val retrofit = RetrofitBuilder()

    override fun getPosts() {

        retrofit.getPosts().enqueue(object : Callback<ArrayList<PostResponse>> {
            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                when {
                    response.code() == 200 -> {
                        if (response.isSuccessful) {
                            val posts = response.body()
                            view.refreshPosts(posts!!)
                        } else {
                            view.onError("Something is wrong")
                        }
                    }
                    response.code() == 404 -> {
                        view.onError("Not found data")
                    }
                    response.code() == 500 -> {
                        view.onError("Internal server error")
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                view.onError("No connection. Error: $t")
            }

        })
    }


}