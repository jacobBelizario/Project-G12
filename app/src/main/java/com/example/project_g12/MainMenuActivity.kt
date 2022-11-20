package com.example.project_g12

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project_g12.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var data = DataSource.getInstance().testUser

        binding.tvUserNameHeader.text = "${data.userName}"
        var lessonListAdapter:LessonListAdapter =LessonListAdapter(this,data.lessonList)
        binding.llLessons.adapter = lessonListAdapter
    }
}