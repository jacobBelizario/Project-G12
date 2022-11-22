package com.example.project_g12

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.project_g12.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var data = DataSource.getInstance().user
        binding.swSequentialProgression.isChecked = DataSource.getInstance().switchStatus
        binding.tvUserNameHeader.text = "${data.userName}"
        var lessonListAdapter: LessonListAdapter = LessonListAdapter(this, data.lessonList)
        if (binding.swSequentialProgression.isChecked) {
            DataSource.getInstance().switchStatus = true
            if (!data.lessonList[0].isComplete) {
                var seqLesson = arrayListOf(data.lessonList[0])
                lessonListAdapter = LessonListAdapter(this, seqLesson)
                lessonListAdapter.notifyDataSetChanged()
                binding.llLessons.adapter = lessonListAdapter
            } else if (data.lessonList[0].isComplete) {
                var seqLesson = arrayListOf(data.lessonList[0], data.lessonList[1])
                lessonListAdapter = LessonListAdapter(this, seqLesson)
                lessonListAdapter.notifyDataSetChanged()
                binding.llLessons.adapter = lessonListAdapter
            } else if (data.lessonList[1].isComplete) {
                var seqLesson =
                    arrayListOf(data.lessonList[0], data.lessonList[1], data.lessonList[2])
                lessonListAdapter = LessonListAdapter(this, seqLesson)
                lessonListAdapter.notifyDataSetChanged()
                binding.llLessons.adapter = lessonListAdapter
            } else if (data.lessonList[2].isComplete) {
                var seqLesson = arrayListOf(
                    data.lessonList[0],
                    data.lessonList[1],
                    data.lessonList[2],
                    data.lessonList[3]
                )
                lessonListAdapter = LessonListAdapter(this, seqLesson)
                lessonListAdapter.notifyDataSetChanged()
                binding.llLessons.adapter = lessonListAdapter
            }

        }
        else {
            DataSource.getInstance().switchStatus = false
            lessonListAdapter = LessonListAdapter(this, data.lessonList)
            lessonListAdapter.notifyDataSetChanged()
            binding.llLessons.adapter = lessonListAdapter
        }

        binding.llLessons.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedLesson = data.lessonList[position]
                // setting the lesson to the singleton
                DataSource.getInstance().selectedLesson = selectedLesson
                var intent = Intent(this, SelectedLessonActivity::class.java)
                startActivity(intent)
            }
        binding.swSequentialProgression.setOnCheckedChangeListener { compoundButton, b ->
            if (binding.swSequentialProgression.isChecked) {
                DataSource.getInstance().switchStatus = true
                if (!data.lessonList[0].isComplete) {
                    var seqLesson = arrayListOf(data.lessonList[0])
                    lessonListAdapter = LessonListAdapter(this, seqLesson)
                    lessonListAdapter.notifyDataSetChanged()
                    binding.llLessons.adapter = lessonListAdapter
                } else if (data.lessonList[0].isComplete) {
                    var seqLesson = arrayListOf(data.lessonList[0], data.lessonList[1])
                    lessonListAdapter = LessonListAdapter(this, seqLesson)
                    lessonListAdapter.notifyDataSetChanged()
                    binding.llLessons.adapter = lessonListAdapter
                } else if (data.lessonList[1].isComplete) {
                    var seqLesson =
                        arrayListOf(data.lessonList[0], data.lessonList[1], data.lessonList[2])
                    lessonListAdapter = LessonListAdapter(this, seqLesson)
                    lessonListAdapter.notifyDataSetChanged()
                    binding.llLessons.adapter = lessonListAdapter
                } else if (data.lessonList[2].isComplete) {
                    var seqLesson = arrayListOf(
                        data.lessonList[0],
                        data.lessonList[1],
                        data.lessonList[2],
                        data.lessonList[3]
                    )
                    lessonListAdapter = LessonListAdapter(this, seqLesson)
                    lessonListAdapter.notifyDataSetChanged()
                    binding.llLessons.adapter = lessonListAdapter
                }

            }
            else {
                DataSource.getInstance().switchStatus = false
                lessonListAdapter = LessonListAdapter(this, data.lessonList)
                lessonListAdapter.notifyDataSetChanged()
                binding.llLessons.adapter = lessonListAdapter
            }
        }
    }
}