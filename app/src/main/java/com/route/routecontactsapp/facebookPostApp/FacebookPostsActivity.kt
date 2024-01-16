package com.route.routecontactsapp.facebookPostApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.route.routecontactsapp.R
import com.route.routecontactsapp.databinding.ActivityFacebookPostsBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class FacebookPostsActivity : AppCompatActivity() {
    // bindingd take xml file and make java class file and make for each view attribute
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
        val date:Date =Calendar.getInstance().time
        val value = date.toString("yyyy-MMM-dd hh:mm:ss:SS a")
        //2024-January-21 3:20:02:09 am
        postsList = mutableListOf()
        for (i in 1..10 ){
            postsList.add(
                Post(
                    User("Ahmed", R.drawable.img),"This Post is great",
                    R.drawable.img,value)
            )
        }
        }
}
fun Date.toString(format:String ,locale: Locale=Locale.getDefault()):String{
    //locale (language and country )
    val formatter = SimpleDateFormat(format,locale)
    return formatter.format(this)
}
