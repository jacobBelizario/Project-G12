package com.example.project_g12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_g12.databinding.ActivityMainBinding
import com.example.project_g12.databinding.ActivityOldUserBinding

class OldUserActivity : AppCompatActivity() {

    lateinit var datasource:Datasource
    lateinit var binding: ActivityOldUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityOldUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        datasource = Datasource.getInstance()

        // TODO: update using user data
        binding.oldUserTitle.setText("Welcome back, " + datasource.currentUser)
        binding.oldUserProgression.setText("You've completed " + "25" + "% of the course!")
        binding.oldUserCompleted.setText("Lessons completed: " + "1")
        binding.oldUserRemaining.setText("Lessons remaining: " + "4")

        binding.oldUserContinueButton.setOnClickListener {
            // TODO: intent to lesson list
            // startActivity(Intent(this, ))
        }

        binding.oldUserResetButton.setOnClickListener{
            // TODO: reset user data
            datasource.currentUser = null
            startActivity(Intent(this, SplashScreen::class.java))
        }


    }
}