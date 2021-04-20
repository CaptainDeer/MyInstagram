package com.captaindeer.myinstagram.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.captaindeer.myinstagram.R
import com.captaindeer.myinstagram.data.remote.responses.PostResponse
import com.captaindeer.myinstagram.ui.adapters.PostsAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeInterface.View {

    private lateinit var presenter: HomePresenter
    private lateinit var adapter: PostsAdapter
    private var users = arrayListOf<PostResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = HomePresenter(this)
        adapter = PostsAdapter(users)
        presenter.getPosts()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_home.setHasFixedSize(true)
        rv_home.layoutManager = LinearLayoutManager(requireContext())
        rv_home.adapter = adapter

    }

    override fun refreshPosts(posts: ArrayList<PostResponse>) {
        adapter.updateData(posts)
    }

    override fun onError(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

    }
}