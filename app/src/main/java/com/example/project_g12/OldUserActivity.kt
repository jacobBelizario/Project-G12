package com.example.project_g12

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project_g12.databinding.ActivityOldUserBinding

class OldUserActivity : AppCompatActivity() {
    lateinit var binding:ActivityOldUserBinding
    var data = DataSource.getInstance()
    var lessonRemaining = 0
    var lessonCompleted = 0

    fun checkLessonsRemaining() {
        for(lesson in data.lessonList) {
            if(lesson.isComplete) {
                this.lessonCompleted++
            }else {
                this.lessonRemaining++
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOldUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkLessonsRemaining()
        binding.tvUserNameMain.text = data.user.userName
        binding.tvUserNameHeader.text = data.user.userName
        binding.tvLessonCompleted.append(" ${this.lessonCompleted.toString()}")
        binding.tvLessonRemaining.append(" ${this.lessonRemaining.toString()}")
        var percentage:Double = ((this.lessonCompleted).toDouble()/(data.user.lessonList.size).toDouble())*100.0
        binding.tvCoursePercentage.text = "You have completed ${percentage.toInt()}% of the course"
        //button actions
        binding.btnContinue.setOnClickListener {
            var intent = Intent(this,MainMenuActivity::class.java)
            startActivity(intent)
        }
        binding.btnClearData.setOnClickListener {
            data.reset()
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}