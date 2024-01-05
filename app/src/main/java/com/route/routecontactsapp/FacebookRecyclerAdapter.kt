package com.route.routecontactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FacebookRecyclerAdapter(val posts :List<Post>) :RecyclerView.Adapter <FacebookRecyclerAdapter.MyViewHolder>(){
    class MyViewHolder (itemView : View):RecyclerView.ViewHolder(itemView){
        val profileImage :ImageView = itemView.findViewById(R.id.imv_profile_pic)
        val postImage :ImageView = itemView.findViewById(R.id.imv_profile_pic)
        val chooserImage :ImageView = itemView.findViewById(R.id.imv_profile_chooser)
        val profileName :TextView = itemView.findViewById(R.id.tv_profile_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post,parent ,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return posts.size?:0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val post = posts[position]
        holder.profileImage.setImageResource(post.image)
        holder.chooserImage.setImageResource(post.image)
        holder.postImage.setImageResource(post.image)
        holder.profileName.text =post.name
    }
}