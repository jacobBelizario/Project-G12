package com.example.project_g12

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 300000 // loading time: 1 sec
    lateinit var datasource:DataSource

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
        datasource = DataSource.getInstance()
        if(datasource.user != null){
            startActivity(Intent(this, OldUserActivity::class.java))
        }else{
            startActivity(Intent(this, NewUserActivity::class.java))
        }

    }


}