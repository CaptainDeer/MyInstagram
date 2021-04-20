package com.captaindeer.myinstagram.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.myinstagram.R
import com.captaindeer.myinstagram.data.remote.responses.PostResponse
import com.captaindeer.myinstagram.ui.adapters.viewHolder.PostViewHolder
import com.squareup.picasso.Picasso

class PostsAdapter(private var posts: ArrayList<PostResponse>): RecyclerView.Adapter<PostViewHolder>() {

    fun updateData(posts: ArrayList<PostResponse>){
        this.posts = posts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent,false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]

        holder.titlePost.text = post.title
        holder.descriptionPost.text = post.description
        Picasso.get().load(post.image).placeholder(R.drawable.ic_launcher_background).into(holder.imgPost)

    }

    override fun getItemCount(): Int = posts.size
}