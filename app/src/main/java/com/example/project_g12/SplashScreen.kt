package com.example.project_g12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 300000 // loading time: 1 sec
    lateinit var datasource:Datasource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_splash)

    }

    override fun onStart() {
        super.onStart()

        // SPLASH EFFECT
        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)

        // CHECK IF NEW USER
        datasource = Datasource.getInstance()
        if(datasource.currentUser != null){
            startActivity(Intent(this, OldUserActivity::class.java))
        }else{
            startActivity(Intent(this, NewUserActivity::class.java))
        }

    }


}