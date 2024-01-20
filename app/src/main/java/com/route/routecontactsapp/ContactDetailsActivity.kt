package com.route.routecontactsapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.core.content.IntentCompat
import com.route.routecontactsapp.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity : AppCompatActivity() {
    lateinit var binding:ActivityContactDetailsBinding
    var contactDetailsObj:Contact? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        extractParams()
        binding.contactDetailsImv.setImageResource(contactDetailsObj?.image?:R.drawable.profile)
    }
    private fun extractParams() {
        contactDetailsObj = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.contactDetails, Contact::class.java)
        } else {
            intent.getParcelableExtra<Contact>(Constants.contactDetails) as Contact
        }
    }
}