package com.captaindeer.myinstagram.ui.home

import com.captaindeer.myinstagram.data.remote.responses.PostResponse
import com.captaindeer.myinstagram.ui.bases.BaseView

interface HomeInterface {

    interface Presenter {
        fun getPosts()
    }

    interface View: BaseView{
        fun refreshPosts(posts: ArrayList<PostResponse>)
    }

}