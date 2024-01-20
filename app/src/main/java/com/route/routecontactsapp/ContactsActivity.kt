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
    var contactsList= mutableListOf<Contact>()
    lateinit var adapter: ContactsRecyclerAdapter
    var contactObj:Contact? =null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        // constrain layout of RV
        setContentView(binding.root)
        extractParams()
        initRecyclerView()




    }
    private fun extractParams() {
        contactObj = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.contact, Contact::class.java)
        } else {
            intent.getParcelableExtra<Contact>(Constants.contact) as Contact
        }
    }

    private fun createContactsList(name: String?, phone: String?, description: String?) {
        contactsList.add(Contact(name?:"",phone?:"", description?:"",contactObj?.image ?:R.drawable.profile))
    }

    private fun initRecyclerView() {
        createContactsList(contactObj?.name ,contactObj?.phone,contactObj?.description)

        adapter = ContactsRecyclerAdapter(this.contactsList)
        binding.rvContactsItemsList.adapter = adapter
        adapter.notifyItemInserted(contactsList.size-1)
        adapter.onContactClickListener =ContactsRecyclerAdapter.OnContactClickListener {
                contact,position ->  navigateToContactDetailsActivity(contact)
        }
        }

    private fun navigateToContactDetailsActivity(contact: Contact) {
        val intent = Intent(this,ContactDetailsActivity::class.java)
        intent.putExtra(Constants.contactDetails,contact)
        startActivity(intent)
    }



    }

