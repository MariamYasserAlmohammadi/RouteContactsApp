package com.route.routecontactsapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity :  AppCompatActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        // object from handler // use mainLooper   //have many Looper
        //postDelayed take 2 parameters
        // looper class responsible for take tasks in mainThread and give it to cpu
        Handler(mainLooper).postDelayed(
            {
                startContactsActivity()
            },2000
        )
    }

    private fun startContactsActivity() {
        // :: reflections gives us informations about class
        //  كود مبني اساسا من جافا مش عايز object,  عايز بس يعرف حيروح فين reflection (name of class and in any package)
     startActivity(Intent(this,MainActivity::class.java))
        finish()

    }
}