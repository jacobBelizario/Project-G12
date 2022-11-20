package com.example.project_g12

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.project_g12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val splashTimeOut:Long = 3000 // 1 sec
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val dataSource = DataSource.getInstance()
            if(dataSource.testUser.userName.isNullOrEmpty()) {
                val intent = Intent(this, NewUserActivity::class.java)
                startActivity(intent)
            }else {
                val intent = Intent(this, OldUserActivity::class.java)
                startActivity(intent)
            }

        }, splashTimeOut)


    }
}