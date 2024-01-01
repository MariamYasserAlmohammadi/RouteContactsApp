package com.route.routecontactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.routecontactsapp.databinding.ActivityContactsBinding


class ContactsActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactsBinding
    lateinit var adapter: ContactsRecyclerAdapter
    lateinit var contactsList: MutableList<Contact>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent =intent
        if (intent==null)
            return;
        val name =intent.getStringExtra("name")
        val phone =intent.getStringExtra("phone")
        val description =intent.getStringExtra("description")
        createContactsList(name,phone,description)
        contactsList = mutableListOf()
        initRecyclerView()

    }
    fun createContactsList(name:String?,phone:String?,description:String?){
        contactsList.add(Contact(name, phone, description, R.drawable.profile))

    }

    private fun initRecyclerView() {
        adapter = ContactsRecyclerAdapter(this.contactsList)
        binding.rvContactsItemsList.adapter =adapter



    }
}