package com.example.project_g12

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project_g12.databinding.ActivityNewUserBinding

class NewUserActivity : AppCompatActivity() {

    lateinit var dataSource: DataSource
    lateinit var binding: ActivityNewUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityNewUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var datasource = DataSource.getInstance()

        binding.newUserContinueButton.setOnClickListener{
            if(binding.newUserName.text.isNullOrEmpty()){
                binding.newUserName.setError("Please enter your name")
            }else{
                datasource.createUser(binding.newUserName.text.toString())
                startActivity(Intent(this, MainMenuActivity::class.java))
            }
        }

    }

}
