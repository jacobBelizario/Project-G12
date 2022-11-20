package com.example.project_g12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import com.example.project_g12.databinding.ActivityOldUserBinding

class OldUserActivity : AppCompatActivity() {
    lateinit var binding:ActivityOldUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOldUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var data = DataSource.getInstance().userName
        //set placeholders to username
        binding.tvUserNameMain.text = data
        binding.tvUserNameHeader.text = data
    }
}