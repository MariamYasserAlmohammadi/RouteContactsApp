package com.route.routecontactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var saveButton: Button
    lateinit var nameET: EditText
    lateinit var phoneET: EditText
    lateinit var descriptionET: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        saveButton =findViewById(R.id.btn_save)
        saveButton.setOnClickListener { view ->
            onSaveButtonClick(view)
        }
    }

    private fun onSaveButtonClick(view:View?) {
        this.nameET = findViewById<EditText>(R.id.edt_name)
        this.phoneET=findViewById(R.id.edt_phone_number)
        this.descriptionET=findViewById(R.id.edt_description)

        var nameInput  = this.nameET.text.toString()
        var phoneInput  = this.phoneET.text.toString()
        var descriptionInput  = this.descriptionET.text.toString()

        val intent = Intent(this,ContactsActivity::class.java)
        intent.putExtra("name",nameInput)
        intent.putExtra("phone",phoneInput)
        intent.putExtra("description",descriptionInput)
        startActivity(intent)
//        clearEditText()


    }


    private fun clearEditText() {
        this.nameET.text.clear()
        this.phoneET.text.clear()
        this.descriptionET.text.clear()
    }

}