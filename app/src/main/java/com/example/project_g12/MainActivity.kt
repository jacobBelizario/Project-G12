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
    lateinit var dataSource: DataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()


        Handler(Looper.getMainLooper()).postDelayed({
            dataSource = DataSource.getInstance()
            if(!dataSource.oldUser()) {
                val intent = Intent(this, NewUserActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this, OldUserActivity::class.java)
                startActivity(intent)
            }

        }, splashTimeOut)
    }
}