package com.captaindeer.myinstagram.ui.adapters.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.captaindeer.myinstagram.R
import kotlinx.android.synthetic.main.item_post.view.*

class PostViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val imgPost = view.findViewById(R.id.iv_post) as ImageView
    val titlePost = view.findViewById(R.id.tvTitlePost) as TextView
    val descriptionPost = view.findViewById(R.id.tvDescriptionPost) as TextView
}