package com.route.routecontactsapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.core.content.IntentCompat
import com.route.routecontactsapp.databinding.ActivityContactsBinding


class ContactsActivity : AppCompatActivity() {
    lateinit var binding: ActivityContactsBinding
    lateinit var contactsList: MutableList<Contact>
    lateinit var adapter: ContactsRecyclerAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        // constrain layout of RV
        setContentView(binding.root)
        contactsList = mutableListOf()
        val contact  =intent.parcelable<Contact>(Constants.contact)
        contact?.let {
                contact ->{
            val name=contact.name
            val phone=contact.phone
            val description=contact.description
            createContactsList(name ,phone,description)
        }
        }
        initRecyclerView()


    }

    private fun createContactsList(name: String, phone: String, description: String) {

        contactsList.add(Contact(name,phone, description))
    }
    inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
        Build.VERSION.SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
        else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
    }


    private fun initRecyclerView() {

        adapter = ContactsRecyclerAdapter(this.contactsList)
        binding.rvContactsItemsList.adapter = adapter
        adapter.onContactClickListener =ContactsRecyclerAdapter.OnContactClickListener {
            contact ->  navigateToContactDetailsActivity(contact)
        }
        }

    private fun navigateToContactDetailsActivity(contact: Contact) {
        val intent = Intent(this,ContactDetailsActivity::class.java)
        intent.putExtra("contact",contact)
        startActivity(intent)
    }



    }

