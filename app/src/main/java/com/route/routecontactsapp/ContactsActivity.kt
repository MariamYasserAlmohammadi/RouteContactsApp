package com.route.routecontactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.routecontactsapp.databinding.ActivityContactsBinding


class ContactsActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactsBinding
    lateinit var adapter: ContactsRecyclerAdapter
    lateinit var contactsList: MutableList<Contact>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        if (intent == null)
            return;
        val name:String= intent.getStringExtra("name").toString()
        val phone:String = intent.getStringExtra("phone").toString()
        val description:String = intent.getStringExtra("description").toString()
        contactsList = mutableListOf()
        createContactsList(name, phone, description)
        initRecyclerView()

    }

    fun createContactsList(name: String, phone: String, description: String) {
        for (i in 1..10) {
            contactsList.add(Contact(name, phone, description, R.drawable.profile))
        }

    }

    private fun initRecyclerView() {
        adapter = ContactsRecyclerAdapter(this.contactsList)
        binding.rvContactsItemsList.adapter = adapter
        adapter.onContactClickListener = ContactsRecyclerAdapter.OnContactClickListener { contact ->
            navigateToPokemonDetailsActivity(contact)
        }


    }

    private fun navigateToPokemonDetailsActivity(contact: Contact) {
        val intent = Intent(this, ContactDetailsActivity::class.java)
           // intent.putExtra("contact",contact)
        startActivity(intent)
    }

}