package com.example.project_g12

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project_g12.databinding.ActivityMainBinding
import com.example.project_g12.databinding.ActivityNewUserBinding

class NewUserActivity : AppCompatActivity() {

    lateinit var datasource:Datasource
    lateinit var binding: ActivityNewUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityNewUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        datasource = Datasource.getInstance()

        binding.newUserContinueButton.setOnClickListener{
            if(binding.newUserName.text.isEmpty() || binding.newUserName.text.toString().trim().length == 0){
                binding.newUserName.setError("Please enter your name")
            }else{
                datasource.currentUser = binding.newUserName.text.toString()
//                TODO: intent to lessons list
//                startActivity(Intent(this, ))
            }
        }

    }
}