package com.route.routecontactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.route.routecontactsapp.databinding.ActivityContactsBinding
import com.route.routecontactsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var name: String
    lateinit var phone: String
    lateinit var description: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener(
            {
                if (!validateTextFields()) {
                    // assert only from this scoop
                    return@setOnClickListener
                }
                onSaveButtonClick()
            }
        )

    }

    private fun onSaveButtonClick() {
        name = binding.edtName.text?.trim().toString()
        phone = binding.edtPhone.text?.trim().toString()
        description = binding.edtDescription.text?.trim().toString()
        val contact = Contact(name, phone, description,R.drawable.profile)
        intent = Intent(this, ContactsActivity::class.java)
        intent.putExtra(Constants.contact, contact)
        startActivity(intent)
    }

    fun validateTextFields(): Boolean {
        name = binding.edtName.text?.trim().toString()
        phone = binding.edtName.text?.trim().toString()
        binding.tilName.error = validateName(name)
        binding.tilPhone.error = validatePhone(phone)
        return (validateName(name) == null && validatePhone(phone) == null)
    }

    fun validateName(name: String): String? {
        if (name.isEmpty())
            return "Required"
        if (name.trim().length < 3)
            return "Name cant be less than 3 characters"
        return null
    }

    fun validatePhone(phone: String): String? {
        if (phone.isEmpty())
            return "Required"
//        if (phone.trim().length < 11)
//            return "Name cant be less than 11 digits"
        return null

    }


}