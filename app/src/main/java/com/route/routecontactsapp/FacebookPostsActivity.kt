package com.route.routecontactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.route.routecontactsapp.databinding.ActivityFacebookPostsBinding

class FacebookPostsActivity : AppCompatActivity() {
    lateinit var binding:ActivityFacebookPostsBinding
    lateinit var postsList: MutableList<Post>
    lateinit var adapter: FacebookRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityFacebookPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        binding.rvItemPostList.layoutManager =LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

    }

    private fun initRecyclerView() {
        createPostsList()
        adapter = FacebookRecyclerAdapter(postsList)
        binding.rvItemPostList.adapter =adapter
    }

    private fun createPostsList() {
        postsList = mutableListOf()
        for (i in 1..10 ){
            postsList.add(Post(R.drawable.img,"Ahmed"))
            postsList.add(Post(R.drawable.profile,"Nanny"))
        }
        }
}