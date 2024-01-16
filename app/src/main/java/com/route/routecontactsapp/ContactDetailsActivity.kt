package com.route.routecontactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.IntentCompat
import com.route.routecontactsapp.databinding.ActivityContactDetailsBinding

class ContactDetailsActivity : AppCompatActivity() {
    lateinit var binding:ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // val contact =IntentCompat.getParcelableExtra(intent,Constants.contact,Contact::class.java)
    }
}