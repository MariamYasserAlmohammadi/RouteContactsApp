package com.route.routecontactsapp.facebookPostApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.routecontactsapp.R

class FacebookRecyclerAdapter(val postList :List<Post>?) :RecyclerView.Adapter <FacebookRecyclerAdapter.MyViewHolder>(){
    class MyViewHolder (itemView : View):RecyclerView.ViewHolder(itemView){
        val profileImage :ImageView = itemView.findViewById(R.id.imv_profile_pic)
        val postImage :ImageView = itemView.findViewById(R.id.imv_profile_pic)
        val chooserImage :ImageView = itemView.findViewById(R.id.imv_profile_chooser)
        val profileName :TextView = itemView.findViewById(R.id.tv_profile_name)
        val postContent :TextView=itemView.findViewById(R.id.tv_post_content)
        val postDate :TextView=itemView.findViewById(R.id.tv_post_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post,parent ,false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return postList?.size?:0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val post = postList?.get(position)
        holder.profileImage.setImageResource(post?.author?.profileImage?: R.drawable.img)
        holder.chooserImage.setImageResource(post?.author?.profileImage?: R.drawable.img)
        holder.postImage.setImageResource(post?.author?.profileImage?: R.drawable.img)
        holder.postDate.text=post?.date
        holder.postContent.text=post?.content
        holder.profileName.text =post?.author?.name
    }
}